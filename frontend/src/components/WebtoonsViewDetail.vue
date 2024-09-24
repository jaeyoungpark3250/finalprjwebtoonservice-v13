<template>

    <v-card outlined>
        <v-card-title>
            Webtoons # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="UserId" v-model="item.userId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="WebtoonId" v-model="item.webtoonId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Title" v-model="item.title" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="Point" v-model="item.point" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Episode" v-model="item.episode" :editMode="editMode" @change="change" />
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
    name: 'WebtoonsViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/webtoons/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

