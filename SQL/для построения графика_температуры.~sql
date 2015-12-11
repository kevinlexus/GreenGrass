select a.id, a.n1, o.name, a.ts, a.rowid from A_OBJXPROP a, T_OBJXPROP t, t_obj o where t.fk_prop='CELSIUS_VAL'
and t.fk_obj=o.id
and a.fk_prop_id=t.id --and o.name like '%зал%'
order by o.name, a.id
