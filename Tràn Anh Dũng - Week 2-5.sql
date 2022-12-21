-- Bai 1: Viet lenh tao bang
create table CAMPUS(
    CampusID number(20) primary key,
    CampusName varchar2(100),
    Street varchar2(100),
    City varchar2(100),
    State varchar2(100),
    Zip varchar2(100),
    Phone varchar2(100),
    CampusDiscount Decimal(2,2)
);

create sequence CAMPUS_seq
start with 1
Increment by 1

create table Position(
    PositionID number(20) primary key,
    POSITION varchar2(100),
    YearlyMembershipFee Decimal(7,2)
);
create sequence Position_seq
start with 1
Increment by 1

create table MEMBERS(
    MemberID number(20) primary key,
    LastName varchar2(100),
    FirstName varchar2(100),
    CampusAddress varchar2(100),
    CampusPhone varchar2(100),
    CampusID number(20),
    PositionID number(20),
    ContractDuration integer,
    constraint fk_position foreign key (PositionID) references Position(PositionID)
);

create sequence MEMBERS_seq
start with 1
Increment by 1


create table Prices(
    FoodItemTypeID number(20) primary key,
    MealType varchar2(100),
    MealPrice Decimal(7,2)
);
create sequence Prices_seq
start with 1
Increment by 1

create table FoodItems(
    FoodItemID number(20) primary key,
    FoodItemName varchar2(100),
    FoodItemTypeID number(20),
    constraint fk_foodItem foreign key(FoodItemTypeID) references Prices(FoodItemTypeID)
);
create sequence FoodItems_seq
start with 10000
Increment by 1


create table Orders(
    OrderID number(20) primary key,
    MemberID number(20),
    OrderDate varchar2(25),
    constraint fk_member foreign key(MemberID) references Members(MemberID)
);
create sequence Orders_seq
start with 1
Increment by 1

create table OrderLine(
    OrderID number(20),
    FoodItemsID number(20),
    Quantity integer,
    constraint order_pk primary key(OrderID, FoodItemsID),
    constraint fk_order foreign key(OrderID) references Orders(OrderID),
    constraint fk_foodItems foreign key (FoodItemsID) references FoodItems(FoodItemID)
);

create sequence OrderLine_seq
start with 1
increment by 1

create sequence Prices_FoodItemTypeID_SEQ;


-- Bai 2: Viet Chen Du Lieu
-- CAMPUS TABLE
insert into CAMPUS values (CAMPUS_seq.nextval,'IUPUI','425 University Blvd.','Indianapolis', 'IN','46202', '317-274-4591',.08);
insert into CAMPUS values (CAMPUS_seq.nextval,'Indiana University','107 S. Indiana Ave.','Bloomington', 'IN','47405', '812-855-4848',.07);
insert into CAMPUS values (CAMPUS_seq.nextval,'Purdue University','475 Stadium Mall Drive','West Lafayette', 'IN','47907', '765-494-1776',.06);

-- POSITION TABLE
insert into POSITION values(POSITION_seq.nextval,'Lecturer', 1050.50);
insert into POSITION values(POSITION_seq.nextval,'Associate Professor', 900.50);
insert into POSITION values(POSITION_seq.nextval,'Assistant Professor', 875.50);
insert into POSITION values(POSITION_seq.nextval,'Professor', 700.75);
insert into POSITION values(POSITION_seq.nextval,'Full Professor', 500.50);

-- MEMBERS TABLE
insert into MEMBERS values(MEMBERS_seq.nextval,'Ellen','Monk','009 Purnell', '812-123-1234', '2', '5', 12);
insert into MEMBERS values(MEMBERS_seq.nextval,'Joe','Brady','008 Statford Hall', '765-234-2345', '3', '2', 10);
insert into MEMBERS values(MEMBERS_seq.nextval,'Dave','Davidson','007 Purnell', '812-345-3456', '2', '3', 10);
insert into MEMBERS values(MEMBERS_seq.nextval,'Sebastian','Cole','210 Rutherford Hall', '765-234-2345', '3', '5', 10);
insert into MEMBERS values(MEMBERS_seq.nextval,'Michael','Doo','66C Peobody', '812-548-8956', '2', '1', 10);
insert into MEMBERS values(MEMBERS_seq.nextval,'Jerome','Clark','SL 220', '317-274-9766', '1', '1', 12);
insert into MEMBERS values(MEMBERS_seq.nextval,'Bob','House','ET 329', '317-278-9098', '1', '4', 10);
insert into MEMBERS values(MEMBERS_seq.nextval,'Bridget','Stanley','SI 234', '317-274-5678', '1', '1', 12);
insert into MEMBERS values(MEMBERS_seq.nextval,'Bradley','Wilson','334 Statford Hall', '765-258-2567', '3', '2', 10);

-- PRICES TABLE
insert into PRICES values(PRICES_seq.nextval,'Beer/Wine', 5.50);
insert into PRICES values(PRICES_seq.nextval,'Dessert', 2.75);
insert into PRICES values(PRICES_seq.nextval,'Dinner', 15.50);
insert into PRICES values(PRICES_seq.nextval,'Soft Drink', 2.50);
insert into PRICES values(PRICES_seq.nextval,'Lunch', 7.25);

-- FoodItems Table
insert into FoodItems values(FOODITEMS_seq.nextval,'Lager', 1);
insert into FoodItems values(FOODITEMS_seq.nextval,'Red Wine', 1);
insert into FoodItems values(FOODITEMS_seq.nextval,'White Wine', 1);
insert into FoodItems values(FOODITEMS_seq.nextval,'Coke', 4);
insert into FoodItems values(FOODITEMS_seq.nextval,'Coffee', 4);
insert into FoodItems values(FOODITEMS_seq.nextval,'Chicken a la King', 3);
insert into FoodItems values(FOODITEMS_seq.nextval,'Rib Steak', 3);
insert into FoodItems values(FOODITEMS_seq.nextval,'Fish and Chips', 3);
insert into FoodItems values(FOODITEMS_seq.nextval,'Veggie Delight', 3);
insert into FoodItems values(FOODITEMS_seq.nextval,'Chocolate Mousse', 2);
insert into FoodItems values(FOODITEMS_seq.nextval,'Carrot Cake', 2);
insert into FoodItems values(FOODITEMS_seq.nextval,'Fruit Cup', 2);
insert into FoodItems values(FOODITEMS_seq.nextval,'Fish and Chips', 5);
insert into FoodItems values(FOODITEMS_seq.nextval,'Angus Beef Burger', 5);
insert into FoodItems values(FOODITEMS_seq.nextval,'Cobb Salad', 5);

-- ORDERS TABLE
insert into ORDERS values(ORDERS_seq.nextval,9,'March 5, 2005');
insert into ORDERS values(ORDERS_seq.nextval,8,'March 5, 2005');
insert into ORDERS values(ORDERS_seq.nextval,7,'March 5, 2005');
insert into ORDERS values(ORDERS_seq.nextval,6,'March 7, 2005');
insert into ORDERS values(ORDERS_seq.nextval,5,'March 7, 2005');
insert into ORDERS values(ORDERS_seq.nextval,4,'March 10, 2005');
insert into ORDERS values(ORDERS_seq.nextval,3,'March 5, 2005');
insert into ORDERS values(ORDERS_seq.nextval,2,'March 6, 2005');
insert into ORDERS values(ORDERS_seq.nextval,1,'March 7, 2005');

-- ORDERLINE Table
insert into ORDERLINE values(1,10001,1);
insert into ORDERLINE values(1,10006,1);
insert into ORDERLINE values(1,10012,1);

insert into ORDERLINE values(2,10004,2);
insert into ORDERLINE values(2,10013,1);
insert into ORDERLINE values(2,10014,1);

insert into ORDERLINE values(3,10005,1);
insert into ORDERLINE values(3,10011,1);

insert into ORDERLINE values(4,10005,2);
insert into ORDERLINE values(4,10004,2);
insert into ORDERLINE values(4,10006,1);
insert into ORDERLINE values(4,10007,1);
insert into ORDERLINE values(4,10010,2);

insert into ORDERLINE values(5,10003,1);

insert into ORDERLINE values(6,10002,2);

insert into ORDERLINE values(7,10005,2);

insert into ORDERLINE values(8,10005,1);
insert into ORDERLINE values(8,10011,1);

insert into ORDERLINE values(9,10001,1);

-- Bai 3: Viet lenh truy van theo yeu cau
-- 1 liet ke tat ca constraints trong database
select * from user_constraints;

-- 2 Liet ke tat ca ten bang trong database
select table_name from all_tables;

-- 3 Viet lenh liet ke ten tat ca sequence trong database
select sequence_name from dba_sequences;

-- 4 Liet ke cac thanh vien voi cac cot FirstName, LastName, Position, CampusName, (YearlyMembershipFee / 12) Monthly_Dues. Sap xep theo ten dai hoc giam dan, LastName tang dan

Select mb.FirstName, mb.LastName, ps.Position, cp.CampusName, (ps.YearlyMembershipFee / 12) Monthly_Dues
from Members mb, Position ps, Campus cp
where (1=1) and ((cp.CampusID = mb.PositionID) and(ps.PositionID = mb.PositionID))
order by cp.CampusName desc, mb.LastName asc;
