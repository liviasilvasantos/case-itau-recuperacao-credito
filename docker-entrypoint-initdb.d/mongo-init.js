//dbCustomer
dbCustomer = new Mongo().getDB("dbCustomer");
dbCustomer.createCollection("customers");
dbCustomer.createUser(
    {
        user: "customer",
        pwd: "customer",
        roles: [{
                role: "readWrite",
                db: "dbCustomer"
            }]
    }
);
dbCustomer.customers.insertMany([
    {
        name: 'Lívia Santos',
        email: 'liviasantos@email.com'
    },
    {
        name: 'Rafael Sousa',
        email: 'rafaelsousa@email.com'
    }  
]);

//dbNotification
dbNotification = new Mongo().getDB("dbNotification");
dbNotification.createCollection("notifications");
dbNotification.createUser(
    {
        user: "notification",
        pwd: "notification",
        roles: [
            {
                role: "readWrite",
                db: "dbNotification"
            }
        ]
    }
);
dbNotification.notifications.insertMany([
    {
        type: "SMS",
        createdAt: new Date(Date.now()),
        customerEmail: "liviasantos@email.com"
    },
    {
        type: "WHATSAPP",
        createdAt: new Date(Date.now()),
        customerEmail: "liviasantos@email.com"
    }
]);