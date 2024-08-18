<template>
  <div class="app">
    <router-view />
  </div>
</template>

<style>
.app {
  text-align: center;
  background-image: url("./assets/bg.png");
  background-size: cover;
  height: 100%;
  width: 100%;
  z-index: -1;
  position: absolute;
}
</style>