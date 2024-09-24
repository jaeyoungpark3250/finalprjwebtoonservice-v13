<template>

    <v-data-table
        :headers="headers"
        :items="histories"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'HistoriesView',
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
                { text: "myPoint", value: "myPoint" },
                { text: "point", value: "point" },
                { text: "status", value: "status" },
            ],
            histories : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/histories'))

            temp.data._embedded.histories.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.histories = temp.data._embedded.histories;
        },
        methods: {
        }
    }
</script>

