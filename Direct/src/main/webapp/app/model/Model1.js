Ext.define('TestApp.model.Model1', {
    extend: 'Ext.data.Model',
            fields: ['id', 'name', 'cd', 'proc', 'sel'],
            proxy: {
		autoSave: true,
                //autoSync: true,
                type: 'ajax',
	        api: {
                create  : '',
                read    : 'http://localhost:8090/getSprgenitm',
                update  : 'http://localhost:8090/editSprgenitm',
                destroy : ''
                },
                reader: {
		   type: 'json'
                },
  	        writer: {
                   type: 'json',
		   allowSingle: false //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
		   /*,
                   writeAllFields: true*/  //писать весь объект в json - не имеет смысла
                }
            }
});