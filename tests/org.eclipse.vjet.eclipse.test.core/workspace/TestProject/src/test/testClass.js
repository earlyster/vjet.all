vjo.needs('vjo.dsf.Error');
vjo.needs('vjo.dsf.test.*');
vjo.needsLib("someLib");

vjo.type('test.testClass')
.protos({
 constructs : function () {
  this.svcHdls = {};
 },
  //> public void registerSvcHdl(Object svcId, Object handler) 
 registerSvcHdl : function(svcId, handler) {
  this.svcHdls[svcId] = handler;
 },
 getSvcHdl : function(svcId) {
  return this.svcHdls[svcId];
 },
 handleRequest : function(message) {
  var handler = this.svcHdls[message.svcId];
  if (handler) {
   //> changed to use message rather than message.request
   var response = new vjo.dsf.ServiceResponse();
   response.data = handler.invoke(message);
   message.trace = message.trace + '-->SvcHdl_' + message.svcId;
   if (response) {
    message.response = response;
   }
  }
  if (typeof message.status == 'undefined' || message.status == null) {
   message.status = 1; //back to response chain
  }
 }
}) .props({
     //> public String foo(String name)
     foo : function (name) {
     },
     bar : function () {
     }
});