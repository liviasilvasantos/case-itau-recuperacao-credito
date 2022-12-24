db = new Mongo().getDB("dbCustomer");

//customers
db.createCollection("customers");
db.createUser(
    {
        user: "customer",
        pwd: "customer",
        roles: [{
                role: "readWrite",
                db: "dbCustomer"
            }]
    }
);

db.customers.insertMany([
    {
        name: 'Lívia Santos',
        email: 'liviasantos@email.com'
    },
    {
        name: 'Rafael Sousa',
        email: 'rafaelsousa@email.com'
    }  
]);