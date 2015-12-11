del reglogsxe.log
del exp_gg.dmp
expdp gg/monemyro content=all directory=BACKUP dumpfile=exp_gg.dmp logfile=expdpBACKUP.log
rar a exp_gg exp_gg.dmp
*del exp_gg.dmp