<template>
  <div class="infoHeader">
    <el-card>
      <el-row>
        <h2>{{ this.city }}</h2>
        <el-col :span="12">
          <div class="daily">
            <img width="200" src="../assets/weater_elements/cloudy-day.svg" alt />
            <p>{{ Math.round(this.current.temp) }}°</p>
          </div>
        </el-col>

        <el-col :span="12">
          <div class="todayDetails">
            <div class="item">
              <img width="64" src="../assets/weater_elements/humity.png" alt />
              <h2 style="margin-left: 30px">{{ Math.round(this.current.humidity) }}%</h2>
            </div>

            <div class="item">
              <img width="64" src="../assets/weater_elements/down.png" alt />
              <h2 style="margin-left: 30px">{{ Math.round(this.current.temp_min) }}°</h2>
            </div>

            <div class="item">
              <img width="64" src="../assets/weater_elements/up.png" alt />
              <h2 style="margin-left: 30px">{{ Math.round(this.current.temp_max) }}°</h2>
            </div>
          </div>
        </el-col>
      </el-row>
    </el-card>

    <el-card>
      <div class="card-2">
        <div class="daysDetail">
          <span
            style="display:flex; flex-direction:column; align-items:center; padding-left:10px"
            v-for="(data, index) in this.forecast.list"
            :key="index"
          >
            <p>{{ dateFilter(data.dt) }}</p>
            <img
              :src="require(`../assets/weater_elements/${weathers[data.weather[0].main]}.svg`)"
              width="100px"
              alt
            />
            <p>{{ data.weather[0].main }}</p>
            <p>{{ parseInt(data.temp.day) }}° / {{ parseInt(data.temp.night) }}°</p>
          </span>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script>
import moment from "moment";

export default {
  data() {
    return {
      time: "",
      weathers: {
        Snow: "snowy",
        Clouds: "cloudy",
        Rain: "rainy",
        Clear: "sunny",
        Thunderstorm: "thunder",
        showcard: false
      },
      days: [
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday"
      ]
    };
  },
  props: ["current", "forecast", "city"],
  methods: {
    dateFilter(res) {
      return this.days[moment(parseInt(res + "000")).format("d")];
    }
  }
};
</script>

<style>
.test {
  margin: 0 auto;
}
.infoHeader {
  text-align: center;
  padding-bottom: 50px;
}

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

.el-card {
  text-align: center;
  margin-top: 20px;
  margin-left: 15%;
  margin-right: 15%;
}

.daily {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
  font-size: 90px;
}

.todayDetails {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  flex-wrap: wrap;
}

.item {
  display: flex;
  flex-direction: row;
  align-items: flex-start;
  justify-content: center;
  flex-wrap: wrap;
  margin: 10px;
}

.card-2 {
  width: 100%;
  height: 300px;
  background-color: white;
  border-radius: 10px;
  padding: 20px;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: stretch;
  overflow: auto;
}

.daysDetail {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-around;
  font-size: 23px;
}
</style>