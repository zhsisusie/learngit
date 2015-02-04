//轮播动画
(function($){
	//$.fn是指jquery的命名空间，加上fn上的方法及属性，会对jquery每一个实例有效。如果是$.直接接上函数名，则是添加jquery类方法，相当于静态方法。
	$.fn.fadeAnimate = function(options){
	//合并options与自定义数组，并把结果传回给options
		options = $.extend({
			liDomList: $(this).find('li'),
			liDomListLen: $(this).find('li').length,
			//disableAutoEle: $('#account-box'),
			curIndex: 0,
			nextIndex: 1,
			curDom:undefined,
			nextDom:undefined,
			curLeft:0,
			minLeft:-1470,
			fadeLock: false,
			fadeTime: 5000,
			imgWidth: 1470,
			controller: $('#top-main .controller'),
			controllerList: $('#top-main .controller li'),
			timer: undefined,//计时器
			accSpeed: 4,//进入速度
			Cx: 0.02, //阻力系数
			minRes: 1, //最小阻力
			curSpeed: 0//当前速度
		}, options);		

		//移动到某个DOM对象（图）
		function changeTo(index){
			if(true == options.fadeLock){return;}
			window.clearTimeout(options.timer);
			options.nextIndex = index;
			options.fadeLock = true;

			//初始化
			options.curDom = options.liDomList.eq(options.curIndex);
			options.nextDom = options.liDomList.eq(options.nextIndex);
			//显示下一个Dom
			options.nextDom.css('opacity',0);//设置为透明
			options.curLeft = 0;
			options.curSpeed = 0;
			options.nextDom.css('left', options.curLeft + options.imgWidth);
			controlChange(options.nextIndex);

			move();
		}

		//动画
		function move(){
			var nextLeft = getNextLeft();//以上一张图片偏移为基准
			//偏移越小越不透明
			var opacity = Math.abs(nextLeft/options.imgWidth);
			var opacityPer = parseInt(opacity * 100);
			options.curDom.css({'left': nextLeft, 'opacity': 1-opacity, 'filter': 'alpha(opacity=' + (100 - opacityPer) + ')'});

			options.nextDom.css({'left': nextLeft + options.imgWidth, 'opacity': opacity, 'filter': 'alpha(opacity=' + opacityPer + ')'});
			if(nextLeft <= options.minLeft){   //如果上一张图片消失，设下一张图片为当前图片。
				options.curIndex = options.nextIndex;
				options.fadeLock = false;
				autoFade();
			}else{
				window.setTimeout(move, 20);	//如果上一张图片没有消失，继续左移
			}
		}

		//获取下次速度，
		function getNextSpeed(){
			var incSpeed = options.accSpeed - options.minRes - options.curSpeed * options.Cx; 
			return options.curSpeed += incSpeed;
		}

		//获取下次偏移left
		function getNextLeft() {
			var nextSpeed = getNextSpeed();
			options.curLeft = options.curLeft - nextSpeed < options.minLeft ? options.minLeft : options.curLeft - nextSpeed;
			return options.curLeft;
		}

		//获取下个索引
		function changeNext() {
			var nextIndex = options.curIndex + 1 >= options.liDomListLen ? 0 : options.curIndex + 1; 	
			changeTo(nextIndex);
		}	

		//轮播图按钮点击效果
		//delegate() 方法为指定的元素（属于被选元素的子元素）添加一个或多个事件处理程序，并规定当这些事件发生时运行的函数。
		options.controller.delegate('li', 'click', function(e){
			var index = $(e.currentTarget).index();//获得其监听器触发了事件的那个元素
			changeTo(index);
		});

		//手动控制
		function controlChange(index) {
			options.controllerList.eq(index).addClass('current').siblings('.current').removeClass('current');
		}

		//自动轮播
		function autoFade() {
			window.clearTimeout(options.timer);	
			options.timer = window.setTimeout(changeNext, options.fadeTime);	
		}

		autoFade();

		/*
		options.disableAutoEle.focusin(function(){
			window.clearTimeout(options.timer);	
		}).focusout(function(){
			autoFade();
		})
		*/
		//鼠标进入当前对象时静止，移开时自动轮播。
		$(this).mouseenter(function(){
			window.clearTimeout(options.timer);	
		}).mouseleave(function(){
			autoFade();
		});

		return $(this);
	};	
})(jQuery);
