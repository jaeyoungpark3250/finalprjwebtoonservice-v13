<template>

    <v-card outlined>
        <v-card-title>
            Histories # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="WebtoonId" v-model="item.webtoonId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="MyPoint" v-model="item.myPoint" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'HistoriesViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/histories/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

