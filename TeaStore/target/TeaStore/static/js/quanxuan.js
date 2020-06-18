function toPage(pageNo){
	$("#pageNo").val(pageNo);
	$("#searchFrom").submit();
}
$(function(){
	//全选全不选
	$(".all_btn").on('click', function() {
		$(".all_btn").prop("checked", this.checked);
		$("[name=ids]").prop("checked", this.checked);
	});

	$("[name=ids]").on('click', function() {
		var $subs = $("[name=ids]");
		$(".all_btn").prop("checked", $subs.length == $subs.filter(":checked").length ? true : false);

	});
	
	//对商品数量添加加减单击事件0
	$('#add').click(function() {
		var value = parseInt($('.spll').val());
		value = value + 1;
		$('.spll').val(value);
	});
	$('.jian').click(function() {
		const parent = $(this).parent().parent();
		var value = parseFloat(parent.find('.spll').val());
		if(value > 1) {
			value = value - 1;
		}
		//修改订单项的价格
		updatePrice(parent,value)
	});
	$('.jia').click(function() {
		const parent = $(this).parent().parent();
		var value = parseFloat(parent.find('.spll').val());
		value = value + 1;
		//修改订单项的价格
		updatePrice(parent,value)
	});
	
	$('.spll').change(function(){
		const parent = $(this).parent().parent();
		var value = parseFloat(parent.find('.spll').val());
		//修改订单项的价格
		updatePrice(parent,value)
	})
	
	function updatePrice(parent,value){
		const price = parseFloat(parent.find(".price").text()*value).toFixed(2);
		parent.find('.itemPrice').text(price)
		parent.find(".spll").val(value);
		const id = parent.find(".ids").val();
		updateCount(id,value)
	}
	
	function updateCount(id,value){
		$.get("Cart?method=updateItemCount&goodsId="+id+"&itemCount="+value)
	}
	
});