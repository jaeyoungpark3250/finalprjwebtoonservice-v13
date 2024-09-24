<template>

    <v-data-table
        :headers="headers"
        :items="purchases"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'PurchasesView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "userId", value: "userId" },
                { text: "webtoonId", value: "webtoonId" },
                { text: "point", value: "point" },
                { text: "status", value: "status" },
                { text: "myPoint", value: "myPoint" },
            ],
            purchases : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/purchases'))

            temp.data._embedded.purchases.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.purchases = temp.data._embedded.purchases;
        },
        methods: {
        }
    }
</script>

