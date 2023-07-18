import React, { useEffect } from 'react'
import axios from 'axios';

const baseURL = "http://localhost:8080/api/invoice_management/customers";
function CustomersList() {

  const [customers, setCustomers] = React.useState([]);

  useEffect(()=>{
    axios.get(baseURL).then((response)=>{
      setCustomers(response.data);
    }).catch(error =>{
      console.log(error);
    })
  },[]);

  return (
    <div>
  <h1 className='text-center'>Customers</h1>
<table className="table table-striped table-bordered table-responsive">
	<thead>
		<tr>
			<th> Name</th>
			<th>Phone Number </th>
			<th>Email</th>
      <th>Address</th>
      <th>Actions</th>
		</tr>
	</thead>
	<tbody>
    {
    customers.map(customer =>
    <tr key={customer.id}>
			<td>{customer.name}</td>
			<td>{customer.email}</td>
			<td>{customer.phoneNumber}</td>
      <td>{customer.address.city}, {customer.address.street}, nr.{customer.address.number}, {customer.address.country}</td>
      <td></td>
		</tr>
    )
    }
	</tbody>
</table>

    </div>
  )
}

export default CustomersList