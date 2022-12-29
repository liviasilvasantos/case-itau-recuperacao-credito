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

//dbCatalog
dbCatalog = new Mongo().getDB("dbCatalog");
dbCatalog.createCollection("catalogs");
dbCatalog.createUser(
    {
        user: "catalog",
        pwd: "catalog",
        roles: [
            {
                role: "readWrite",
                db: "dbCatalog"
            }
        ]
    }
);
dbCatalog.catalogs.insertMany([
    {
        code: "PIX-40%",
        description: "à vista, no PIX, 40% de desconto!",
        deadline: "5h",
        paymentType: "PIX",
        discount: 0.40,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    },
    {
        code: "BOLETO-20%",
        description: "à vista, no Boleto, com 20% de desconto!",
        deadline: "2d",
        paymentType: "BILLING_SLIP", 
        discount: 0.20,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    },
    {
        code: "CARTAO-10%-5meses",
        description: "à prazo, no Cartão de Crédito, 10% de desconto, em 5x!",
        deadline: "5mo",
        numberOfInstallments: 5,
        paymentType: "CREDIT_CARD",
        discount: 0.10,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    }
]);