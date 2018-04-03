//echart-line
var dom = document.getElementById("echart-line");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    xAxis: {
        type: 'category',
        data: ['北京', '上海', '深圳', '广州', '厦门', '杭州', '珠海', '南京', '东菀', '苏州']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [22000, 18200, 19100, 23400, 29000, 33000, 31000, 12300, 44200, 32100],
        type: 'line',
        symbol: 'triangle',
        symbolSize: 20,
        lineStyle: {
            normal: {
                color: 'green',
                width: 4,
                type: 'dashed'
            }
        },
        itemStyle: {
            normal: {
                borderWidth: 3,
                borderColor: 'yellow',
                color: 'blue'
            }
        }
    }]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}