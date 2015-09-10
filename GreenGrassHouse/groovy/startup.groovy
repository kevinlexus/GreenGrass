println 'Startup of GGH'
//println GGE.appC
//GGE.crEvent('Здравствуйте, меня зовут Анфиса!', 3600, 1, 'GGV', 'snd1',0,0)

//GGE.clearEvents() - чистится в программе
GGE.crEvent('Умный дом, версия 1 2 5!', 1, 1, 'GGV', 'snd1', 0)


//Сброс защелок комфортности
T_KITCH1.setBool('LATCHED_MAX_VAL', false)
T_KITCH1.setBool('LATCHED_MIN_VAL', false)
T_KITCH1.setBool('LATCHED_COMFORT_VAL', false)

T_BATH1.setBool('LATCHED_MAX_VAL', false)
T_BATH1.setBool('LATCHED_MIN_VAL', false)
T_BATH1.setBool('LATCHED_COMFORT_VAL', false)

T_LVN1.setBool('LATCHED_MAX_VAL', false)
T_LVN1.setBool('LATCHED_MIN_VAL', false)
T_LVN1.setBool('LATCHED_COMFORT_VAL', false)

T_BEDRM1.setBool('LATCHED_MAX_VAL', false)
T_BEDRM1.setBool('LATCHED_MIN_VAL', false)
T_BEDRM1.setBool('LATCHED_COMFORT_VAL', false)

T_OUTDOOR1.setBool('LATCHED_MAX_VAL', false)
T_OUTDOOR1.setBool('LATCHED_MIN_VAL', false)
T_OUTDOOR1.setBool('LATCHED_COMFORT_VAL', false)


