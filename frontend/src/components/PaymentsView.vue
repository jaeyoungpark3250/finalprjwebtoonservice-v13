<template>

    <v-data-table
        :headers="headers"
        :items="payments"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PaymentsView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "price", value: "price" },
                { text: "userId", value: "userId" },
                { text: "status", value: "status" },
                { text: "myPoint", value: "myPoint" },
            ],
            payments : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/payments'))

            temp.data._embedded.payments.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.payments = temp.data._embedded.payments;
        },
        methods: {
        }
    }
</script>

