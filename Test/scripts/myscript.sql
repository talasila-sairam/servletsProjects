select * from TEST;
insert into Test values(100,'sairam',6000,'Hyderabad');
create or replace function myfunction return as number
begin
	variable emp1 number;
      select * from test where empnamer='sairam';
      return emp1;
end 
/