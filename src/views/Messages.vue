<template>
    <div class="board">
        <div class="boardTitle">
            留言板?
        </div>
        <div class="boardHeader">
            <p>已经在做了!</p>
        </div>
    </div>
</template>

<script>

  export default {
    name: "Messages",
    components:{
    }
  }
</script>

<style lang="less" scoped>
    .board{
        display: flex;
        justify-content: center;
        /*align-items: center;*/
        border-radius: 10px;
        flex-direction: column;
        /*min-height: 100vh;*/
        .boardTitle{
            text-align: center;
            background-color: #ffc48c;
            font-size:25px;
            border-top-right-radius: 10px;
            border-top-left-radius: 10px;
            padding: 15px;
        }
        width: 80%;
        margin:0 auto;
        /*background-color: white;*/
        margin-top:20px;
        margin-bottom: 20px;
        .boardHeader{
            text-align: center;
            /*margin: 30px;*/
            padding: 30px;
            border-bottom-right-radius: 10px;
            border-bottom-left-radius: 10px;
            background-color: #fff;
            p{
                font-size: 20px;
                font-weight: 500;
                margin:10px;
            }
        }
    }
    @media screen and (max-width: 800px){
        .board{
            /*box-sizing: border-box;*/
            width:90%;
            /*margin:0 auto;*/
            /*padding: 0 20px;*/
        }
    }

</style>