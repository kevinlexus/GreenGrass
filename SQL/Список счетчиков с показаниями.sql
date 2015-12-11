select o.name, o.owfs_cd, t.*, t.rowid from T_OBJXPROP t, t_obj o where t.fk_prop in ('CUR_BIT', 'CUR_VALUE', 'TRIGGERED', 'COUNTED') 
and t.fk_obj=o.id
order by o.name
