<template>
    <table>
        <tr>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Email</th>
            <th>Adresse</th>
        </tr>
        <tr v-for="customer in customersList">
            <td>{{ customer.first_name }}</td>
            <td>{{ customer.last_name }}</td>
            <td>{{ customer.email_client }}</td>
            <td>{{ customer.address_client }}</td>
        </tr>
    </table>
</template>
<script>
   import axios from 'axios';
   export default {
       name: customersList,
       data(){
           return{
               customersList: [],
               errors: [],
           }

       },
       created() {
           this.getCustomersList();
       },
       methods:{
         getCustomersList(){
             var customersListUrl ='/rest/clients/list';
             axios.get(customersListUrl).then( response =>
                 this.customersList = response.data
             ).catch( e =>
                 this.errors.push(e)
             )
         }
       }
   }
</script>