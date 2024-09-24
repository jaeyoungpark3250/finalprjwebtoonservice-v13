<template>

    <v-data-table
        :headers="headers"
        :items="customers"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'CustomersView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "point", value: "point" },
            ],
            customers : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/customers'))

            temp.data._embedded.customers.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.customers = temp.data._embedded.customers;
        },
        methods: {
        }
    }
</script>

