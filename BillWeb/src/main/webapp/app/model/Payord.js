/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.model.Payord', {
    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        { name: 'id', type: 'int' , persist: false,// persist = false, иначе будет пытаться сохранить ID
            defaultValue: 0, convert: null},
        { name: 'name', type: 'string' },
        { name: 'periodTpFk', type: 'int', convert: null},
        { name: 'selDays', type: 'string' },
        { name: 'username', type: 'string', persist: false },
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false },
        { name: 'formula', type: 'string' },
        { name: 'summa', type: 'float', persist: false }

    ],
    proxy: { // прокси должна находиться в модели. иначе ничего не будет работать при type: 'ajax'
        type: 'ajax',
        api: {
            create  : 'http://192.168.100.21:8083/payord/addPayord',
            read    : 'http://192.168.100.21:8083/payord/getPayord',
            update  : 'http://192.168.100.21:8083/payord/setPayord',
            destroy : 'http://192.168.100.21:8083/payord/delPayord'
        },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
            allowSingle: false //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
        }
    }
});