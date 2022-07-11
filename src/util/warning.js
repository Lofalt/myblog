export default function(that,message) {
  const h = that.$createElement;
  that.$message({
    message: h('p', {style:'background-color:white'}, [
      h('span', { style: 'color: teal;background-color:white' }, message)
    ])
  });
}