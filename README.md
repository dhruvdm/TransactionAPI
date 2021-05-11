
# TransactionAPI 

<b> Endpoint to populate Dummy Data for testing</b>
Method - GET
URL - localhost:8082/accounts/transactions/createData


#Get Transactions for Given Account
Method - POST
URL - localhost:8082/accounts/transactions

Sample Request Body:
{
    "accountNumber" : "11220000002"
}
 
<b>Notes:</b>
#Please note that sample data is created for testing purpose. 
#Account Type (saving/current) is retrieved by making a rest call internally. If not found it will be returned as blank.
#Make sure the account service is running on local host. 
#Default URL to get account type service is "http://127.0.0.1:8081/customer/account/type" which can be modified in application properties.
