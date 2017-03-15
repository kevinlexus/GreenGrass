/**
 * This class is the view model for the Main view of the application.
 */
Ext.define('BillWebApp.view.main.MainModel', {
    extend: 'Ext.app.ViewModel',

    alias: 'viewmodel.main',

    data: {
        name: 'BillWebApp',
        loremIpsum: 'Редактирование платежек',
        periodId1: '',
        periodId2: '',
        orgId: ''
    },

    stores: {
        periodstore1: {
            type: 'periodstore1' // refers to the alias you set up on your store definition
        },
        periodstore2: {
            type: 'periodstore1'
        },
        payordstore: {
            type: 'payordstore'
        },
        payordgrpstore: {
            type: 'payordgrpstore'
        },
        payordcmpstore: {
            type: 'payordcmpstore'
        },
        lststore: {
            type: 'lststore'
        },
        servstore: {
            type: 'servstore'
        },
        orgstore: {
            type: 'orgstore'
        },
        orgcuruserstore: {
            type: 'orgcuruserstore'
        }
    }

});
