import com.liviasilvasantos.itau.notification.domain.Notification
import com.liviasilvasantos.itau.notification.domain.NotificationContext
import com.liviasilvasantos.itau.notification.gateway.CustomerGateway
import com.liviasilvasantos.itau.notification.gateway.NotificationGateway
import com.liviasilvasantos.itau.notification.mocks.MockCustomer
import com.liviasilvasantos.itau.notification.mocks.MockNotification
import com.liviasilvasantos.itau.notification.usecase.SendNotification
import com.liviasilvasantos.itau.notification.usecase.strategy.NotificationStrategy
import spock.lang.Specification

class SendNotificationSpec extends Specification {

    def customerGateway = Mock(CustomerGateway)
    def notificationGateway = Mock(NotificationGateway)
    def strategy1 = Mock(NotificationStrategy)
    def strategy2 = Mock(NotificationStrategy)
    def strategy3 = Mock(NotificationStrategy)

    def sendNotification

    def setup() {
        def notificationStrategies = List.of(strategy1, strategy2, strategy3)
        sendNotification = new SendNotification(notificationStrategies,
                customerGateway, notificationGateway)
    }

    def "should send notification"() {
        given: "a valid notification"
        def notification = MockNotification.VALID_PIX()

        and: "customer is found"
        def customer = MockCustomer.VALID()
        1 * customerGateway.findById(notification.customerId) >> customer

        and: "strategy 2 can execute"
        1 * strategy2.canExecute(_ as NotificationContext) >> true

        when: "send notification is invoked"
        sendNotification.execute(notification)

        then: "notification is saved"
        1 * notificationGateway.save(_ as Notification)

        and: "strategy 2 is invoked"
        1 * strategy2.execute(_ as NotificationContext)
    }

}