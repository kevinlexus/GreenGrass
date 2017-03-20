/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.model.PayordGrp', {
    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        { name: 'id', type: 'int' , persist: false,// persist = false, иначе будет пытаться сохранить ID
            defaultValue: 0, convert: null},
        { name: 'name', type: 'string' },
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false },
        { name: 'username', type: 'string', persist: false }

    ],
    proxy: { // прокси должна находиться в модели. иначе ничего не будет работать при type: 'ajax'
        autoSave: true,
        type: 'ajax',
        api: {
            create  : 'http://192.168.100.21:8083/addPayordGrp',
            read    : 'http://192.168.100.21:8083/getPayordGrpAll',
            update  : 'http://192.168.100.21:8083/setPayordGrp',
            destroy : 'http://192.168.100.21:8083/delPayordGrp'
        },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
            allowSingle: false/*, //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
            writeAllFields: true*/  //писать весь объект в json - не имеет смысла
        }
    }
});