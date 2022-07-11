<template>
    <div :style="{transform:currentButtonTransform}" class="navButton" @click="showNav">
        <div class="icons"></div>
        <div class="icons"></div>
        <div class="icons"></div>
    </div>
</template>

<script>
  export default {
    name: "NavButton"
  }
</script>

<style scoped>

</style>