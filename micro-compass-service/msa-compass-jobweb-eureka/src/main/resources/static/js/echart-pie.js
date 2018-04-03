//echart-pie
var dom = document.getElementById("echart-pie");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    title : {
        text: '职位预测分析最终报告',
        subtext: '云计算提供',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['北京', '上海', '深圳', '广州', '厦门', '杭州', '珠海', '南京', '东菀', '苏州']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'北京'},
                {value:310, name:'上海'},
                {value:234, name:'深圳'},
                {value:135, name:'广州'},
                {value:1548, name:'厦门'},
                {value:435, name:'杭州'},
                {value:510, name:'珠海'},
                {value:634, name:'南京'},
                {value:735, name:'东菀'},
                {value:8548, name:'苏州'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}