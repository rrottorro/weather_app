$(document).ready(function(){
    $('#TOKYO_btn').on('click', function(){
        $('#TOKYO_form').attr('action', '/weather_forecast');
        $('#TOKYO_form').submit();
    });
});

// ボタンが押下されたタイミングでサブミットする
function testClick(btn){
    btn.form.submit();
}
