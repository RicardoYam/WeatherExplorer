<template>
  <div class="container">

    <h1 style="margin-top: 0px; margin-bottom: 0px;" class="header">Weather Explorer</h1>

    <Search @current="getCurrent" @forecast="getForecast" @city="getCity" @showcard="showcard = true"/>

    <Card :current="this.current" :forecast="this.forecast" :city="this.city" v-if="showcard"/>
  </div>
</template>

<script>
import Search from "../components/Search.vue";
import Card from "../components/Card.vue";

export default {
  name: "Home",
  components: { Search, Card },
  data() {
    return {
      current: "",
      forecast: "",
      city: "",
      showcard: false
    };
  },
  methods: {
    getCurrent(data) {
      this.current = data;
    },
    getForecast(data) {
      this.forecast = data;
    },
    getCity(data) {
      this.city = data;
    }
  }
};
</script>

<style> 
.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}

.image {
  width: 100%;
  display: block;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both;
}

.header {
  font-size: 55px;
  font-family: 'Weather';
  color: white;
  padding-top: 40px;
  padding-bottom: 40px;
}

@font-face {
  font-family: 'Weather';
  src: url('../assets/fonts/weather.ttf');
}
</style>