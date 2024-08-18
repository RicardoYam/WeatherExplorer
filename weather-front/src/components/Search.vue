<template>
  <div class="container">
    <el-form :inline="true" label-width="600px">
      <el-form-item>
        <el-input v-model="query" prefix-icon="el-icon-search" placeholder="Enter a city" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="fetch">Search</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      query: "",
      lat: "",
      lon: "",
      current: [],
      forecast: "",
      city: ""
    };
  },
  methods: {
    async getForecast() {
      await axios
        .get(
          `/jh/data/2.5/forecast/daily?q=${this.city}&units=metric&appid=5cc5d1b67f99a045756c9cb73f969383`
        )
        .then(response => {
          this.forecast = response.data;
          this.$emit("forecast", this.forecast);
          this.$emit("showcard");
        })
        .catch(() => {
          console.log("Fail2");
        });
    },
    async onSearch() {
      await axios
        .get(
          `/jh/data/2.5/weather?lat=${this.lat}&lon=${this.lon}&exclude=minutely,hourly&units=metric&appid=5cc5d1b67f99a045756c9cb73f969383`
        )
        .then(response => {
          this.current = response.data.main;
          this.$emit("current", this.current);
          this.city = response.data.name;
          this.$emit("city", this.city);
          this.getForecast();
        })
        .catch(() => {
          console.log("Fail2");
        });
    },
    fetch() {
      axios
        .get(`/test/city?name=${this.query}`)
        .then(response => {
          this.locaton = response.data.locaton;
          this.lat = response.data.lattitude;
          this.lon = response.data.longitude;
          this.onSearch();
        })
        .catch(() => {
          console.log("Fail");
        });
    }
  }
};
</script>

<style>
.el-input {
  width: 600px;
}
</style>