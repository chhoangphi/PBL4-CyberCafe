use cybercafe;

create table nhan_vien(
	`id_nhan_vien` varchar(50),
    `username` varchar(255),
    `password` varchar(50),
    `ten_nhan_vien` nvarchar(255),
    `ngay_sinh` varchar(10),
    `dia_chi` nvarchar(255),
    `so_dien_thoai` varchar(20),
    `chuc_vu` nvarchar(50),
    `email` varchar(50),
    primary key (id_nhan_vien)
);

create table khach_hang(
	`id_khach_hang` varchar(50),
    `ten_khach_hang` varchar(255),
    `dia_chi` nvarchar(255),
    `so_dien_thoai` varchar(20),
    primary key (id_khach_hang)
);

create table ncc_nguyen_lieu(
	`id_ncc_nl` varchar(50),
    `ten_ncc` varchar(255),
    `dia_chi` nvarchar(255),
    `so_dien_thoai` varchar(20),
    primary key (id_ncc_nl)
);

create table nha_cc_tb(
	`id_ncc_tb` varchar(50),
    `ten_ncc` varchar(255),
    `dia_chi` nvarchar(255),
    `so_dien_thoai` varchar(20),
    primary key (id_ncc_tb)
);

create table thiet_bi_cc_internet(
	`id_thiet_bi` varchar(50),
    `ten_thiet_bi` nvarchar(255),
    `gia` double,
    primary key (id_thiet_bi)
);

create table ban(
	`id_ban` varchar(50),
    `so_cho` int,
    `trang_thai` varchar(20),
    primary key (id_ban)
);

create table menu(
	`id_mon` varchar(50),
    `ten_mon` nvarchar(255),
    `gia` double,
    `phan_loai` varchar(50),
    primary key (id_mon)
);

create table hoa_don_ban_hang(
	`id_hoa_don_ban_hang` varchar(50),
    `id_khach_hang` varchar(50), 
    `ngay_ban` varchar(50), 
    `tong_tien` double, 
    `trang_thai` int,
    primary key(id_hoa_don_ban_hang),
    foreign key(id_khach_hang) references khach_hang(id_khach_hang) on update cascade 
);

create table hoa_don_nhap(
	`id_hoa_don_nhap` varchar(50),
    `ngay_nhap` varchar(50), 
    `tong_tien` double, 
    `id_ncc` varchar(50),
    primary key(id_hoa_don_nhap),
    foreign key(id_ncc) references ncc_nguyen_lieu(id_ncc_nl) on update cascade 
);

create table phuc_vu(
	`id_khach_hang` varchar(50),
    `id_nhan_vien` varchar(50),
    `id_thiet_bi` varchar(50),
    `id_mon` varchar(50),
	`id_ban` varchar(50), 
    `id_hoa_don_ban_hang` varchar(50),
    `trang_thai` int, 
    `so_luong` int, 
    `thoi_gian` varchar(50),
    
    foreign key(id_khach_hang) references khach_hang(id_khach_hang) on update cascade,
    foreign key(id_nhan_vien) references nhan_vien(id_nhan_vien) on update cascade,
    foreign key(id_thiet_bi) references thiet_bi_cc_internet(id_thiet_bi) on update cascade,
    foreign key(id_mon) references menu(id_mon) on update cascade,
    foreign key(id_ban) references ban(id_ban) on update cascade,
    foreign key(id_hoa_don_ban_hang) references hoa_don_ban_hang(id_hoa_don_ban_hang) on update cascade
);

INSERT INTO nhan_vien(`id_nhan_vien`, `username`, `password`, `ten_nhan_vien`, `ngay_sinh`, `so_dien_thoai`, `dia_chi`, `chuc_vu`, `email`) VALUES 
("NV01", "NV01", "NV01", "Phạm Thanh Sơn", "28-03-2001", "0123456789", "Mộ lao-Hà nội", "quản lý", "swpts@duck.com");

INSERT INTO `khach_hang`(`id_khach_hang`, `ten_khach_hang`, `dia_chi`, `so_dien_thoai`) VALUES
("KH01", "Cao Xuân Đạt", "Thái bình", "0981231232");

insert into ban(`id_ban`, `so_cho`, `trang_thai`) values
("B01", 5, "0"),
("B02", 3, "0"),
("B03", 10, "0"),
("B04", 6, "0");

insert into ncc_nguyen_lieu(`id_ncc_nl`, `ten_ncc`, `dia_chi`, `so_dien_thoai`) values
("NCC01", "Fresh Garden", "Thanh Xuân", "0978324546"),
("NCC02", "Chicken Garden", "Thanh Xuân", "0978324546"),
("NCC03", "Tiger Hill", "Hà Nam", "0978324546");

insert into nha_cc_tb(`id_ncc_tb`, `ten_ncc`, `dia_chi`, `so_dien_thoai`) values
("NTB01", "Thăng Long Audio", "Hà Đông", "0986453735");

insert into thiet_bi_cc_internet(`id_thiet_bi`, `ten_thiet_bi`, `gia`) values
("TB01", "Acer Nitro 5", 15000),
("TB02", "ROG Phone 5", 13000);

insert into menu(`id_mon`, `ten_mon`, `gia`, `phan_loai`) values
("DA01", "Khô gà", 20000, ""),
("DA02", "Kem tươi", 26000, ""),
("DU01", "Nước cam", 20000, "Không đường"),
("DU02", "Nước đào", 10000, "Có đường");
