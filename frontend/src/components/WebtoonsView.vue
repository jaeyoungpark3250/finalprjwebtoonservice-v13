<template>

    <v-data-table
        :headers="headers"
        :items="webtoons"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'WebtoonsView',
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
                { text: "title", value: "title" },
                { text: "point", value: "point" },
                { text: "episode", value: "episode" },
                { text: "status", value: "status" },
            ],
            webtoons : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/webtoons'))

            temp.data._embedded.webtoons.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.webtoons = temp.data._embedded.webtoons;
        },
        methods: {
        }
    }
</script>

