db = new Mongo().getDB("dbCustomer");
db.createCollection("customers");

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