//dbCustomer
dbCustomer = new Mongo().getDB("dbCustomer");
dbCustomer.createCollection("customers");
dbCustomer.createUser({
    user: "customer",
    pwd: "customer",
    roles: [{
        role: "readWrite",
        db: "dbCustomer"
    }]
});
dbCustomer.customers.insertMany([
    {
        name: 'Lívia Santos',
        email: 'liviasantos@email.com',
        createdAt: new Date(Date.now()),
        phones: [{
            type: "MOBILE",
            countryCode: 55,
            code: "19",
            number: "991112233"
        }, {
            type: "HOME",
            countryCode: 55,
            code: "19",
            number: "31112233"
        }]
    },
    {
        name: 'Rafael Sousa',
        email: 'rafaelsousa@email.com',
        createdAt: new Date(Date.now()),
        phones: [{
            type: "HOME",
            countryCode: 55,
            code: "19",
            number: "31112244"
        }]
    }  
]);

//dbNotification
dbNotification = new Mongo().getDB("dbNotification");
dbNotification.createCollection("notifications");
dbNotification.createUser({
    user: "notification",
    pwd: "notification",
    roles: [{
        role: "readWrite",
        db: "dbNotification"
    }]
});

//dbCatalog
dbCatalog = new Mongo().getDB("dbCatalog");
dbCatalog.createCollection("catalogs");
dbCatalog.createUser({
    user: "catalog",
    pwd: "catalog",
    roles: [{
        role: "readWrite",
        db: "dbCatalog"
    }]
});
dbCatalog.catalogs.insertMany([
    {
        code: "PIX-40%",
        description: "à vista, no PIX, 40% de desconto!",
        expirationInMinutes: 120, //2h
        paymentType: "PIX",
        discount: 0.40,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    },
    {
        code: "BOLETO-20%",
        description: "à vista, no Boleto, com 20% de desconto!",
        expirationInMinutes: 2880, //2d,
        paymentType: "BILLING_SLIP", 
        discount: 0.20,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    },
    {
        code: "CARTAO-10%-5meses",
        description: "à prazo, no Cartão de Crédito, 10% de desconto, em 5x!",
        numberOfInstallments: 5,
        paymentType: "CREDIT_CARD",
        discount: 0.10,
        createdAt: new Date(Date.now()),
        status: "ACTIVE"
    }
]);

//dbDebt
dbDebt = new Mongo().getDB("dbDebt");
dbDebt.createCollection("debts");
dbDebt.createUser({
    user: "debt",
    pwd: "debt",
    roles: [{
        role: "readWrite",
        db: "dbDebt"
    }]
});

//dbPayment
dbPayment = new Mongo().getDB("dbPayment")
dbPayment.createCollection("payments")
dbPayment.createUser({
    user: "payment",
    pwd: "payment",
    roles: [{
        role: "readWrite",
        db: "dbPayment"
    }]
});
