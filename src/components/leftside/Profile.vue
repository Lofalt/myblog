<template>
    <div>
        <div class="name">
            狗の窝
        </div>
    <div class="profile">
    </div>

    </div>
</template>

<script>
  export default {
    name: "profile"
  }
</script>

<style scoped lang="less">
    .name{
        text-align: center;
        font-size: 25px;
        background-color: #ffc48c;
        color: white;
        padding: 5px;
        margin-bottom:10px;
        border-bottom:3px white inset;
        border-top-left-radius: 10px;
    }
    .profile{
        margin-left:5px;
        margin-right:5px;
        background-image: url(~assets/img/backgroundimg/77855514.jpeg);
        background-size: cover;
        /*margin:10px;*/
        color: #525252;
        text-align: center;
        /*padding-top:70px;*/
        /*padding-bottom: 50px;*/
        height: 240px;
        font-size:1.5em;
        border-radius:50%;
        /*border-bottom: 3px black dashed;*/
        /*border: rgba(124, 120, 116,.1) 1px solid;*/
        box-shadow:0px 0px 5px rgba(139, 128, 118, 0.3);
        background-color: #ffc48c;
        /*-moz-border-radius-bottomleft:10px;*/
        /*-moz-border-radius-bottomright:10px;*/
        /*border-bottom-right-radius: 10px;*/
        /*border-bottom-left-radius: 10px;*/
        &:first-line{
            font-size: 2em;
            font-family: 幼圆;
            font-weight: bold;
            text-shadow: 1px 1px 3px rgba(100,100,100,.5);
        }
    }
</style>