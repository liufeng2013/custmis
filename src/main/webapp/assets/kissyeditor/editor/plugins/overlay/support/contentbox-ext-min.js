KISSY.add("ext-contentbox",function(a){function c(){a.log("contentbox init");this.on("renderUI",this._renderUIContentBox,this);this.on("syncUI",this._syncUIContentBox,this);this.on("bindUI",this._bindUIContentBox,this)}a.namespace("Ext");var d=a.Node;c.ATTRS={contentEl:{},content:{}};c.HTML_PARSER={contentEl:".ks-contentbox"};c.prototype={_syncUIContentBox:function(){a.log("_syncUIContentBox")},_bindUIContentBox:function(){a.log("_bindUIContentBox")},_renderUIContentBox:function(){a.log("_renderUIContentBox");
var b=this.get("contentEl"),e=this.get("el");if(!b){b=(new d("<div class='ks-contentbox'>")).appendTo(e);this.set("contentEl",b)}},_uiSetContent:function(b){a.log("_uiSetContent");b!==undefined&&this.get("contentEl").html(b)},__destructor:function(){a.log("contentbox __destructor")}};a.Ext.ContentBox=c});