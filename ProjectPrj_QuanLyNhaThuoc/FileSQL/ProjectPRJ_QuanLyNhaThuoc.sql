USE [master]
GO
/****** Object:  Database [ProjectPRJ_QuanLyNhaThuoc]    Script Date: 3/21/2022 12:06:57 AM ******/
CREATE DATABASE [ProjectPRJ_QuanLyNhaThuoc]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ProjectPRJ_QuanLyNhaThuoc', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENMINH\MSSQL\DATA\ProjectPRJ_QuanLyNhaThuoc.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ProjectPRJ_QuanLyNhaThuoc_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.NGUYENMINH\MSSQL\DATA\ProjectPRJ_QuanLyNhaThuoc_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProjectPRJ_QuanLyNhaThuoc].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET RECOVERY FULL 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET  MULTI_USER 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProjectPRJ_QuanLyNhaThuoc', N'ON'
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET QUERY_STORE = OFF
GO
USE [ProjectPRJ_QuanLyNhaThuoc]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[AccId] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](50) NULL,
	[Password] [nvarchar](50) NULL,
	[FullName] [nvarchar](50) NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](50) NULL,
	[Phone] [nchar](10) NULL,
	[RoleId] [int] NULL,
 CONSTRAINT [PK_Account] PRIMARY KEY CLUSTERED 
(
	[AccId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Distributor]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Distributor](
	[DistributorId] [int] IDENTITY(1,1) NOT NULL,
	[DistributorName] [nvarchar](100) NULL,
	[Address] [nvarchar](100) NULL,
	[Email] [nvarchar](50) NULL,
	[PhoneNumber] [nchar](10) NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_Manufacture] PRIMARY KEY CLUSTERED 
(
	[DistributorId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImportInvoice]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImportInvoice](
	[ImInvoiceId] [int] IDENTITY(1,1) NOT NULL,
	[DistributorId] [int] NULL,
	[ImDate] [date] NULL,
	[TotalMoney] [int] NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_ImportInvoice] PRIMARY KEY CLUSTERED 
(
	[ImInvoiceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ImportInvoiceDetail]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ImportInvoiceDetail](
	[ImDetailId] [int] IDENTITY(1,1) NOT NULL,
	[ImInvoiceId] [int] NULL,
	[MedicineId] [int] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_ImportInvoiceDetail] PRIMARY KEY CLUSTERED 
(
	[ImDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MedicalBox]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MedicalBox](
	[BoxId] [int] IDENTITY(1,1) NOT NULL,
	[BoxName] [nvarchar](50) NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_MedicalBox] PRIMARY KEY CLUSTERED 
(
	[BoxId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Medicine]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Medicine](
	[MedicineId] [int] IDENTITY(1,1) NOT NULL,
	[MedicineName] [nvarchar](50) NULL,
	[TypeId] [int] NULL,
	[BoxId] [int] NULL,
	[DistributorId] [int] NULL,
	[Unit] [nvarchar](50) NULL,
	[InputPrice] [int] NULL,
	[Price] [int] NULL,
	[ManufactureDate] [date] NULL,
	[OutOfDate] [date] NULL,
	[image] [ntext] NULL,
	[QuantityInStock] [int] NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_Medicine] PRIMARY KEY CLUSTERED 
(
	[MedicineId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OutputInvoice]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OutputInvoice](
	[OutInvoiceId] [int] IDENTITY(1,1) NOT NULL,
	[AccId] [int] NULL,
	[CustomerName] [nvarchar](50) NULL,
	[CustomerPhone] [nvarchar](50) NULL,
	[SaleDate] [date] NULL,
	[TotalMoney] [int] NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_InputInvoice] PRIMARY KEY CLUSTERED 
(
	[OutInvoiceId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OutputInvoiceDetail]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OutputInvoiceDetail](
	[OutDetailIId] [int] IDENTITY(1,1) NOT NULL,
	[OutInvoiceId] [int] NULL,
	[MedicineId] [int] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK_OutputInvoiceDetail] PRIMARY KEY CLUSTERED 
(
	[OutDetailIId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RoleAccount]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RoleAccount](
	[RoleId] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_RollAccount_1] PRIMARY KEY CLUSTERED 
(
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TypeOfMedicine]    Script Date: 3/21/2022 12:06:57 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TypeOfMedicine](
	[TypeId] [int] IDENTITY(1,1) NOT NULL,
	[TypeName] [nvarchar](50) NULL,
	[Note] [ntext] NULL,
 CONSTRAINT [PK_TypeOfMedicine] PRIMARY KEY CLUSTERED 
(
	[TypeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([AccId], [Username], [Password], [FullName], [Address], [Email], [Phone], [RoleId]) VALUES (1, N'admin', N'123456', N'Nguyễn Ngọc Minh', N'Thị trấn, Tiên Lãng, Hải phòng', N'minhnnm1009@gmail.com', N'0868429690', 1)
INSERT [dbo].[Account] ([AccId], [Username], [Password], [FullName], [Address], [Email], [Phone], [RoleId]) VALUES (2, N'user1', N'12345', N'Nguyễn Trọng Hùng', N'Thạch Hòa Thạch Thất Hà Nội', N'hungngu@gmail.com', N'0123456789', 2)
INSERT [dbo].[Account] ([AccId], [Username], [Password], [FullName], [Address], [Email], [Phone], [RoleId]) VALUES (4, N'dat', N'222', N'Pham Tien Dat', N'Thanh Binh, TP.Hai Duong', N'datpthd2001@gmail.com', N'0386152106', 2)
SET IDENTITY_INSERT [dbo].[Account] OFF
GO
SET IDENTITY_INSERT [dbo].[Distributor] ON 

INSERT [dbo].[Distributor] ([DistributorId], [DistributorName], [Address], [Email], [PhoneNumber], [Note]) VALUES (1, N'Trung tâm thuốc Hải Dương', N'Số 3 Ngô quyền', N'haiphongNPP@gmail.com', N'123456789 ', N'')
INSERT [dbo].[Distributor] ([DistributorId], [DistributorName], [Address], [Email], [PhoneNumber], [Note]) VALUES (2, N'Trung tâm thuốc Hà Nội', N'Thạch Hòa Thạch Thất', N'hanoiNPP@gmail.com', N'2345678   ', NULL)
SET IDENTITY_INSERT [dbo].[Distributor] OFF
GO
SET IDENTITY_INSERT [dbo].[ImportInvoice] ON 

INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (1, 1, CAST(N'2020-03-23' AS Date), 162500, NULL)
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (2, 1, CAST(N'2020-09-10' AS Date), 300000, NULL)
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (3, 2, CAST(N'2020-06-17' AS Date), 400000, NULL)
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (4, 2, CAST(N'2021-01-01' AS Date), 1820000, NULL)
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (23, 2, CAST(N'2022-03-03' AS Date), 280000, N'Test insert invoice')
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (24, 2, CAST(N'1900-01-01' AS Date), 433270, N'Test insert invoice 2')
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (25, 1, CAST(N'1900-01-01' AS Date), 273270, N'')
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (26, 1, CAST(N'1900-01-01' AS Date), 200000, N'')
INSERT [dbo].[ImportInvoice] ([ImInvoiceId], [DistributorId], [ImDate], [TotalMoney], [Note]) VALUES (27, 2, CAST(N'1900-01-01' AS Date), 546540, N'')
SET IDENTITY_INSERT [dbo].[ImportInvoice] OFF
GO
SET IDENTITY_INSERT [dbo].[ImportInvoiceDetail] ON 

INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (1, 1, 1, 25)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (2, 1, 2, 20)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (3, 2, 3, 10)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (4, 2, 4, 10)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (5, 3, 5, 5)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (6, 4, 6, 10)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (7, 4, 7, 2)
INSERT [dbo].[ImportInvoiceDetail] ([ImDetailId], [ImInvoiceId], [MedicineId], [Quantity]) VALUES (8, 4, 8, 12)
SET IDENTITY_INSERT [dbo].[ImportInvoiceDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[MedicalBox] ON 

INSERT [dbo].[MedicalBox] ([BoxId], [BoxName], [Note]) VALUES (1, N'Ô thuốc 1', N'Tủ trái')
INSERT [dbo].[MedicalBox] ([BoxId], [BoxName], [Note]) VALUES (2, N'Ô thuốc 2', N'Tủ phải')
INSERT [dbo].[MedicalBox] ([BoxId], [BoxName], [Note]) VALUES (3, N'Ô thuốc 3', N'Tủ trái')
INSERT [dbo].[MedicalBox] ([BoxId], [BoxName], [Note]) VALUES (4, N'Ô thuốc 4 ', N'Tủ phải')
SET IDENTITY_INSERT [dbo].[MedicalBox] OFF
GO
SET IDENTITY_INSERT [dbo].[Medicine] ON 

INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (1, N'Kháng sinh', 1, 1, 1, N'Vỉ', 2500, 5000, CAST(N'2022-02-20' AS Date), CAST(N'2025-02-25' AS Date), N'https://images.fpt.shop/unsafe/fit-in/600x600/filters:quality(90):fill(white)/nhathuoclongchau.com/images/product/2019/07/00020528-amoxicillin-500mg-brawn-10x10-1011-5d31_large.png', 20, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (2, N'Panadol extra', 1, 2, 1, N'Vỉ', 5000, 20000, CAST(N'2021-02-21' AS Date), CAST(N'2025-02-21' AS Date), N'data:image/jpeg;base64,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Ivu1oIv5AG67/ClDJPDURR2zER2ubADrW3PkACViNSU/h339mZqYOlh12iWWzjrdtWzxb37zmYRROMrI4o+scXg25O1u7Mfq958VcHDmGupqdkRcHFo5XyjQANbfUgAAXJudysfDfD0dJHZvae713kanwHc0cgu4rtCk4LV7nneJY6OJklBaLnzf2Xdvs3skiIinOaEREAREQFd9KbQ59IwmwLpLnu1jF/YCV3cP4Vo2RgGnicbC5exrzsPpEElcfpOwaebqpYWufkJDg0ZiL2Idl3I0tp4KL01bjMTQxkVTYaC8Uht5XBsPBV21GbujvQozr4KkqVRK2a6vbXM37W3vvpzLGk4ZoSLeiwjyjYD8lUfGeERwVromWDSWkAbDN4eRGnyuuvPiWOnTq6jX6sLvnlXCm4fr5HFz6WoLjuTHJc+NyL3WlWUZRskW+F0KlCrmq1Fa22a/huWjg3CVEaeM9Ux5cxrs1gc12g3vuf8AUrbfwhQkW6ho8g37lXNB+WYGZIo6gN7uqcQPIEaLaNfjhFurqRf/ALVviG3UilG23oUamDxGd/vJ675zh8X4ZFDWuiZa2fYWAF9dBy0IFu8eKsfh3hGi9GieYmyF0YcXEXvmAJ37tlXU3DFc9xc6nqCTuS15JPeSdT5rqUUeMQMDIo6kNGwyXt7wo4JKTdvQ6OMjKpQhCFZXW/xWv5pljf8A5Wh/ksP7DT/gqm41wqGCsMcejdL2+yDe3K97WGlwfJdh9Rj50yT/ALIHyC5UnDOIPcXPppXOOpc65JPmSs1LSVkvQh4dTlRqOdSrFq22e/u+RYvD/CNC2BhdDHM5zA4ueA+99dL7DX4LoTcK0LgQKaJum7Y47/FpVe0NHjUTQyNkzWjYaED2HZbjH4/tkd7o/fspE4/19ChUw9V1G+3i9d3M5XFeDxw1ZazQfVHk1wcBy322u02Vi9G4Aw6MD60n98qv5+GMSkJfJE97zuS5pJ95Vj8C4dLBRsjlGV+Z7stwcoLr2uNPH2rWkvj2LXEqkXg4w7RSknHZp8pd7fPmSNERWDzwREQBERAa1RSRyCz42PH89od815oqCKIERxsjBNyGNDQT36LbRYsr3M5nbLfToERFkwEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQBERAEREAREQH//2Q==', 20, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (3, N'Berberin', 1, 3, 2, N'Lọ', 20000, 120000, CAST(N'2022-01-01' AS Date), CAST(N'2025-01-01' AS Date), N'https://healthvietnam.vn/photos/shares/bietduoc2/berberin-10mg.png', 8, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (4, N'Medoten', 1, 1, 2, N'Vỉ', 10000, 40000, CAST(N'2021-01-01' AS Date), CAST(N'2022-03-05' AS Date), N'https://nhathuocthanthien.com.vn/wp-content/uploads/2020/09/dgm_nttt_Medoten-400-nttt.jpg', 9, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (5, N'Boganic', 2, 3, 2, N'Hộp', 80000, 200000, CAST(N'2021-02-03' AS Date), CAST(N'2022-03-06' AS Date), N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfKaBNRQg3HOSdza--TFWgfpIYKnFE4e_xmES4PfcYIM_96IZH5jRTb5q8IUV3nKYyQHo&usqp=CAU', 5, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (6, N'Bổ thận dương nhất nhất', 2, 3, 1, N'Hộp', 100000, 300000, CAST(N'2021-04-05' AS Date), CAST(N'2025-03-23' AS Date), N'https://www.thuocdantoc.org/wp-content/uploads/2019/08/thuoc-bo-than-5.jpg', 10, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (7, N'Mộc linh chi', 1, 1, 2, N'Hộp', 20000, 180000, CAST(N'2019-02-06' AS Date), CAST(N'2024-05-22' AS Date), N'https://quaythuocvienquany.com/wp-content/uploads/2020/05/thuoc-tang-can-moc-linh-chi-body-weight-hoc-vien-quan-y.jpg', 2, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (8, N'Hoạt huyết nhất nhất', 2, 1, 1, N'Hộp', 60000, 140000, CAST(N'2020-01-09' AS Date), CAST(N'2026-09-10' AS Date), N'https://tudienbenhhoc.com/wp-content/uploads/2018/08/5_636108427103272440_HasThumb.png', 12, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (9, N'Tiffy', 1, 1, 1, N'Vỉ', 3000, 10000, CAST(N'2019-01-02' AS Date), CAST(N'2025-04-05' AS Date), N'data:image/jpeg;base64,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', 17, N'')
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (10, N'Bổ phế Nam Hà', 1, 1, 2, N'Hộp', 20000, 40000, CAST(N'2021-05-08' AS Date), CAST(N'2026-02-01' AS Date), N'https://www.thuocdantoc.org/wp-content/uploads/2019/06/thuoc-ho-bo-phe-nam-ha-chi-khai-lo.jpg', 10, N'')
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (11, N'Sủi cam MyVita', 2, 1, 2, N'Tuýp', 5000, 10000, CAST(N'2020-02-08' AS Date), CAST(N'2024-12-12' AS Date), N'https://giabaonhieutien.com/wp-content/uploads/2021/08/vien-sui-vitamin-c.jpg', 18, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (12, N'Oresol', 2, 3, 2, N'Tuýp', 8000, 15000, CAST(N'2019-04-05' AS Date), CAST(N'2027-06-07' AS Date), N'https://cf.shopee.vn/file/dac3d1e232422d70da1eb6f033a19422', 21, NULL)
INSERT [dbo].[Medicine] ([MedicineId], [MedicineName], [TypeId], [BoxId], [DistributorId], [Unit], [InputPrice], [Price], [ManufactureDate], [OutOfDate], [image], [QuantityInStock], [Note]) VALUES (13, N'Kẹo Vita C', 1, 3, 2, N'Gói', 3000, 8000, CAST(N'2020-04-12' AS Date), CAST(N'2025-08-09' AS Date), N'http://mekomed.vn/upload/product1/vitacglucose0700x467-5114.jpg', 23, NULL)
SET IDENTITY_INSERT [dbo].[Medicine] OFF
GO
SET IDENTITY_INSERT [dbo].[OutputInvoice] ON 

INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (1, 1, N'Hung ngu  ', N'0987654   ', CAST(N'2022-03-20' AS Date), 160000, NULL)
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (2, 2, N'Hùng Đần  ', N'02468     ', CAST(N'2022-03-19' AS Date), 20000, NULL)
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (7, 1, N'minh      ', N'0868429690', CAST(N'2022-03-03' AS Date), 40000, N'Test insert invoice 2')
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (8, 1, N'Minh đẹp trai ', N'0868429690', CAST(N'2022-03-20' AS Date), 880000, N'test outInvoice')
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (9, 1, N'Minh đẹp trai ', N'0868429690', CAST(N'2022-03-03' AS Date), 200000, N'')
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (10, 1, N'Minh đẹp trai vl', N'0868429690', CAST(N'2022-03-15' AS Date), 20000, N'tesst')
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (11, 1, N'Minh đẹp trai ', N'0868429690', CAST(N'2022-03-08' AS Date), 5000, N'tesst')
INSERT [dbo].[OutputInvoice] ([OutInvoiceId], [AccId], [CustomerName], [CustomerPhone], [SaleDate], [TotalMoney], [Note]) VALUES (12, 1, N'Minh đẹp trai vl', N'0868429690', CAST(N'2022-03-14' AS Date), 300000, N'okk')
SET IDENTITY_INSERT [dbo].[OutputInvoice] OFF
GO
SET IDENTITY_INSERT [dbo].[OutputInvoiceDetail] ON 

INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (1, 1, 3, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (2, 1, 4, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (3, 2, 1, 4)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (4, 2, 3, 3)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (5, 2, 7, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (6, 2, 5, 2)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (7, 2, 4, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (8, 2, 5, 2)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (9, 2, 3, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (10, 2, 5, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (11, 8, 3, 2)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (12, 8, 4, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (13, 8, 5, 3)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (14, 9, 5, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (15, 10, 2, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (16, 11, 1, 1)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (17, 12, 1, 4)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (18, 12, 3, 2)
INSERT [dbo].[OutputInvoiceDetail] ([OutDetailIId], [OutInvoiceId], [MedicineId], [Quantity]) VALUES (19, 12, 4, 1)
SET IDENTITY_INSERT [dbo].[OutputInvoiceDetail] OFF
GO
SET IDENTITY_INSERT [dbo].[RoleAccount] ON 

INSERT [dbo].[RoleAccount] ([RoleId], [RoleName]) VALUES (1, N'Giám đốc')
INSERT [dbo].[RoleAccount] ([RoleId], [RoleName]) VALUES (2, N'Nhân viên bán hàng')
SET IDENTITY_INSERT [dbo].[RoleAccount] OFF
GO
SET IDENTITY_INSERT [dbo].[TypeOfMedicine] ON 

INSERT [dbo].[TypeOfMedicine] ([TypeId], [TypeName], [Note]) VALUES (1, N'Thuốc điều trị', NULL)
INSERT [dbo].[TypeOfMedicine] ([TypeId], [TypeName], [Note]) VALUES (2, N'Thực phẩm chức năng', NULL)
SET IDENTITY_INSERT [dbo].[TypeOfMedicine] OFF
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_RollAccount] FOREIGN KEY([RoleId])
REFERENCES [dbo].[RoleAccount] ([RoleId])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_RollAccount]
GO
ALTER TABLE [dbo].[ImportInvoice]  WITH CHECK ADD  CONSTRAINT [FK_ImportInvoice_Manufacture] FOREIGN KEY([DistributorId])
REFERENCES [dbo].[Distributor] ([DistributorId])
GO
ALTER TABLE [dbo].[ImportInvoice] CHECK CONSTRAINT [FK_ImportInvoice_Manufacture]
GO
ALTER TABLE [dbo].[ImportInvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_ImportInvoiceDetail_ImportInvoice] FOREIGN KEY([ImInvoiceId])
REFERENCES [dbo].[ImportInvoice] ([ImInvoiceId])
GO
ALTER TABLE [dbo].[ImportInvoiceDetail] CHECK CONSTRAINT [FK_ImportInvoiceDetail_ImportInvoice]
GO
ALTER TABLE [dbo].[ImportInvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_ImportInvoiceDetail_Medicine] FOREIGN KEY([MedicineId])
REFERENCES [dbo].[Medicine] ([MedicineId])
GO
ALTER TABLE [dbo].[ImportInvoiceDetail] CHECK CONSTRAINT [FK_ImportInvoiceDetail_Medicine]
GO
ALTER TABLE [dbo].[Medicine]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_MedicalBox] FOREIGN KEY([BoxId])
REFERENCES [dbo].[MedicalBox] ([BoxId])
GO
ALTER TABLE [dbo].[Medicine] CHECK CONSTRAINT [FK_Medicine_MedicalBox]
GO
ALTER TABLE [dbo].[Medicine]  WITH CHECK ADD  CONSTRAINT [FK_Medicine_TypeOfMedicine] FOREIGN KEY([TypeId])
REFERENCES [dbo].[TypeOfMedicine] ([TypeId])
GO
ALTER TABLE [dbo].[Medicine] CHECK CONSTRAINT [FK_Medicine_TypeOfMedicine]
GO
ALTER TABLE [dbo].[OutputInvoice]  WITH CHECK ADD  CONSTRAINT [FK_OutputInvoice_Account] FOREIGN KEY([AccId])
REFERENCES [dbo].[Account] ([AccId])
GO
ALTER TABLE [dbo].[OutputInvoice] CHECK CONSTRAINT [FK_OutputInvoice_Account]
GO
ALTER TABLE [dbo].[OutputInvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_OutputInvoiceDetail_Medicine] FOREIGN KEY([MedicineId])
REFERENCES [dbo].[Medicine] ([MedicineId])
GO
ALTER TABLE [dbo].[OutputInvoiceDetail] CHECK CONSTRAINT [FK_OutputInvoiceDetail_Medicine]
GO
ALTER TABLE [dbo].[OutputInvoiceDetail]  WITH CHECK ADD  CONSTRAINT [FK_OutputInvoiceDetail_OutputInvoice] FOREIGN KEY([OutInvoiceId])
REFERENCES [dbo].[OutputInvoice] ([OutInvoiceId])
GO
ALTER TABLE [dbo].[OutputInvoiceDetail] CHECK CONSTRAINT [FK_OutputInvoiceDetail_OutputInvoice]
GO
USE [master]
GO
ALTER DATABASE [ProjectPRJ_QuanLyNhaThuoc] SET  READ_WRITE 
GO
