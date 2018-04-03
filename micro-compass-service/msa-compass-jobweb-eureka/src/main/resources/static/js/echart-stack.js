//echart-stack
var dom = document.getElementById("echart-stack");
var myChart = echarts.init(dom);
var app = {};
option = null;
option = {
    title: {
        text: '历年GDP发展趋势'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['北京', '上海', '深圳', '广州', '厦门', '杭州', '珠海', '南京', '东菀', '苏州']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    toolbox: {
        feature: {
            saveAsImage: {}
        }
    },
    xAxis: {
        type: 'category',
        boundaryGap: false,
        data: ['2008','2009','2010','2011','2012','2013','2014','2015','2016','2017']
    },
    yAxis: {
        type: 'value'
    },
    series: [
        {
            name:'北京',
            type:'line',
            stack: '总量',
            data:[120, 132, 934, 1290, 1330, 1320,1001, 134, 90, 230, 2100]
        },
        {
            name:'上海',
            type:'line',
            stack: '总量',
            data:[220, 182, 191, 234, 290, 3030, 3100, 934, 1290, 1330, 1320]
        },
        {
            name:'深圳',
            type:'line',
            stack: '总量',
            data:[150, 232, 201, 154, 190, 3300, 410,232, 201, 154, 1900]
        },
        {
            name:'广州',
            type:'line',
            stack: '总量',
            data:[320, 332, 301, 334, 390, 930, 320,934, 1290, 1330]
        },
        {
            name:'厦门',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 1290, 1330, 1320,2015,1024,1306]
        },
        {
            name:'杭州',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 890, 930, 620,515,324,506]
        },
        {
            name:'珠海',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 1290, 1330, 1320,2015,1024,1306]
        },
        {
            name:'南京',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 1290, 330, 320,205,104,130]
        },
        {
            name:'东菀',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 934, 1290, 330, 130,201,424,706]
        },
        {
            name:'苏州',
            type:'line',
            stack: '总量',
            data:[820, 932, 901, 320,2015,1024,130, 1934, 120, 330]
        }

    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}