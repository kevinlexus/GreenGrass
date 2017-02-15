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
        periodId2: ''
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
        lststore: {
            type: 'lststore'
        }
    }

});
