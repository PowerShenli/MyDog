$(function() {
    var dcolor = '#218ec3';
    var lcolor = 'rgba(33,142,195,0.7)';
    $("span.pie").peity("pie", {
        fill: [lcolor, '#d7d7d7', '#ffffff']
    })

    $(".line").peity("line",{
        fill: lcolor,
        stroke:dcolor,
    })

    $(".bar").peity("bar", {
        fill: [dcolor, "#d7d7d7"]
    })

    $(".bar_dashboard").peity("bar", {
        fill: [dcolor, "#d7d7d7"],
        width:100
    })

    var updatingChart = $(".updating-chart").peity("line", { fill: lcolor,stroke:dcolor, width: 64 })

    setInterval(function() {
        var random = Math.round(Math.random() * 10)
        var values = updatingChart.text().split(",")
        values.shift()
        values.push(random)

        updatingChart
            .text(values.join(","))
            .change()
    }, 1000);

});
