USE [Articloke]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[ID] [varchar](20) NOT NULL,
	[link] [varchar](200) NOT NULL,
	[linkDemo] [varchar](200) NOT NULL,
	[publishedDate] [date] NOT NULL,
	[permission] [varchar](20) NOT NULL,
	[organization] [varchar](50) NULL,
	[price] [float] NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_Article] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Download]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Download](
	[ID] [varchar](20) NOT NULL,
	[username] [varchar](50) NOT NULL,
	[downloadedDate] [date] NOT NULL,
 CONSTRAINT [PK_Download] PRIMARY KEY CLUSTERED 
(
	[ID] ASC,
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paper]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paper](
	[ID] [varchar](20) NOT NULL,
	[title] [varchar](100) NOT NULL,
	[picture] [varchar](100) NULL,
	[topic] [varchar](50) NOT NULL,
	[description] [varchar](200) NOT NULL,
	[content] [varchar](1000) NOT NULL,
	[createdDate] [date] NOT NULL,
	[modifiedDate] [date] NULL,
	[username] [varchar](50) NOT NULL,
	[publishedStatus] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_Paper] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Reaction]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reaction](
	[ID] [varchar](20) NOT NULL,
	[username] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Interaction] PRIMARY KEY CLUSTERED 
(
	[username] ASC,
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Topic]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Topic](
	[topic] [varchar](50) NOT NULL,
	[picture] [varchar](200) NOT NULL,
 CONSTRAINT [PK_Topic] PRIMARY KEY CLUSTERED 
(
	[topic] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User_]    Script Date: 17/10/2022 20:56:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User_](
	[username] [varchar](50) NOT NULL,
	[email] [varchar](100) NULL,
	[password] [varchar](50) NULL,
	[firstName] [varchar](50) NOT NULL,
	[lastName] [varchar](50) NOT NULL,
	[picture] [varchar](200) NULL,
	[role] [varchar](20) NOT NULL,
	[DOB] [date] NULL,
	[address] [varchar](100) NULL,
	[organization] [varchar](50) NULL,
	[phoneNumber] [varchar](20) NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_User_] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR001', N'Not Yet', N'Not Yet', CAST(N'2022-04-12' AS Date), N'Public', N'FPT', 143.2, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR002', N'Not Yet', N'Not Yet', CAST(N'2022-09-12' AS Date), N'Public', N'LABtory', 123.6, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR003', N'Not Yet', N'Not Yet', CAST(N'2022-11-18' AS Date), N'Public', N'LABtory', 101.1, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR004', N'Not Yet', N'Not Yet', CAST(N'2022-03-18' AS Date), N'Public', N'StarCi MATHyme', 80.1, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR005', N'Not Yet', N'Not Yet', CAST(N'2022-03-18' AS Date), N'Public', N'StarCi MATHyme', 504.2, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR006', N'Not Yet', N'Not Yet', CAST(N'2022-03-18' AS Date), N'Public', N'StarCi MATHyme', 304.1, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR007', N'Not Yet', N'Not Yet', CAST(N'2022-03-18' AS Date), N'Public', N'StarCi MATHyme', 200.1, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR008', N'Not Yet', N'Not Yet', CAST(N'2033-03-01' AS Date), N'Public', N'StarCi MATHyme', 291.2, 1)
INSERT [dbo].[Article] ([ID], [link], [linkDemo], [publishedDate], [permission], [organization], [price], [status]) VALUES (N'AR009', N'Not g', N'fsd', CAST(N'2022-03-01' AS Date), N'Public', N'KiMoChi', 203.2, 1)
GO
INSERT [dbo].[Download] ([ID], [username], [downloadedDate]) VALUES (N'AR001', N'StarCi', CAST(N'2022-02-02' AS Date))
INSERT [dbo].[Download] ([ID], [username], [downloadedDate]) VALUES (N'AR002', N'florentino', CAST(N'2922-02-20' AS Date))
INSERT [dbo].[Download] ([ID], [username], [downloadedDate]) VALUES (N'AR003', N'starci', CAST(N'2292-02-02' AS Date))
GO
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR001', N'Florentino', N'Image/Article/AR001.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2022-01-11' AS Date), CAST(N'2023-01-11' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR002', N'Kahlii', N'Image/Article/AR002.png', N'Mathematics', N'yet', N'sos', CAST(N'2023-01-11' AS Date), CAST(N'2033-01-11' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR003', N'Preyta', N'Image/Article/AR003.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2024-02-02' AS Date), CAST(N'2025-03-01' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR004', N'Zata', N'Image/Article/AR004.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2025-01-01' AS Date), CAST(N'2026-03-11' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR005', N'Tarra', N'Image/Article/AR005.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2022-01-01' AS Date), CAST(N'2022-01-01' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR006', N'Paine', N'Image/Article/AR006.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2022-02-02' AS Date), CAST(N'2022-02-02' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR007', N'Slimz', N'Image/Article/AR007.jpg', N'Mathematics', N'yet', N'sos', CAST(N'2023-02-02' AS Date), CAST(N'2022-02-02' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR008', N'Ignis', NULL, N'Environment', N'yet', N'sos', CAST(N'2055-02-02' AS Date), CAST(N'2025-02-01' AS Date), N'starci', N'Published', 1)
INSERT [dbo].[Paper] ([ID], [title], [picture], [topic], [description], [content], [createdDate], [modifiedDate], [username], [publishedStatus], [status]) VALUES (N'AR009', N'Kirito', NULL, N'Environment', N'yet', N'sos', CAST(N'2099-02-02' AS Date), CAST(N'2099-03-03' AS Date), N'starci', N'Published', 1)
GO
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR007', N'113453348335674169476')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR002', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR004', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR005', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR006', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR007', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR008', N'116399129664329115432')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR001', N'nhoc_ddd')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR003', N'nhoc_ddd')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR004', N'nhoc_ddd')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR009', N'nhoc_ddd')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR001', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR002', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR003', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR004', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR005', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR007', N'starci')
INSERT [dbo].[Reaction] ([ID], [username]) VALUES (N'AR008', N'starci')
GO
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Animal', N'Image/Topic/Animal.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Bacteria', N'Image/Topic/Bacteria.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Chemistry', N'Image/Topic/Chemistry.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'COVID-19', N'Image/Topic/COVID-19.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Environment', N'Image/Topic/Environment.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Mathematics', N'Image/Topic/Mathematics.png')
INSERT [dbo].[Topic] ([topic], [picture]) VALUES (N'Plant', N'Image/Topic/Plant.png')
GO
INSERT [dbo].[User_] ([username], [email], [password], [firstName], [lastName], [picture], [role], [DOB], [address], [organization], [phoneNumber], [status]) VALUES (N'Florentino', N'florentino@gmai.com', N'cuongdeptrai', N'StarCi', N'da Philosopher', N'Image/StarCidaPhilosopher.png', N'Reviewer', CAST(N'3900-12-01' AS Date), N'', N'FPT', NULL, 1)
INSERT [dbo].[User_] ([username], [email], [password], [firstName], [lastName], [picture], [role], [DOB], [address], [organization], [phoneNumber], [status]) VALUES (N'nhoc_ddd', N'cuong1832002@gmail.com', N'cuongpro123', N'Nguyen Van Tu', N'Cuong', N'Image/nhoc_ddd.png', N'Administrator', CAST(N'2002-03-18' AS Date), N'53 Tan Lap 1, Hiep Phu, 9 District, Ho Chi Minh City', NULL, N'0828678897', 1)
INSERT [dbo].[User_] ([username], [email], [password], [firstName], [lastName], [picture], [role], [DOB], [address], [organization], [phoneNumber], [status]) VALUES (N'starci', N'nhoc_ddd@gmail.com', N'123456', N'Nguyen Van', N'Tu Cuong', NULL, N'User', NULL, NULL, N'StarCi MATHyme', NULL, 1)
GO
ALTER TABLE [dbo].[Article]  WITH CHECK ADD  CONSTRAINT [FK_Article_Paper] FOREIGN KEY([ID])
REFERENCES [dbo].[Paper] ([ID])
GO
ALTER TABLE [dbo].[Article] CHECK CONSTRAINT [FK_Article_Paper]
GO
ALTER TABLE [dbo].[Download]  WITH CHECK ADD  CONSTRAINT [FK_Download_Article] FOREIGN KEY([ID])
REFERENCES [dbo].[Article] ([ID])
GO
ALTER TABLE [dbo].[Download] CHECK CONSTRAINT [FK_Download_Article]
GO
ALTER TABLE [dbo].[Download]  WITH CHECK ADD  CONSTRAINT [FK_Download_User_] FOREIGN KEY([username])
REFERENCES [dbo].[User_] ([username])
GO
ALTER TABLE [dbo].[Download] CHECK CONSTRAINT [FK_Download_User_]
GO
ALTER TABLE [dbo].[Paper]  WITH CHECK ADD  CONSTRAINT [FK_Paper_Topic] FOREIGN KEY([topic])
REFERENCES [dbo].[Topic] ([topic])
GO
ALTER TABLE [dbo].[Paper] CHECK CONSTRAINT [FK_Paper_Topic]
GO
ALTER TABLE [dbo].[Paper]  WITH CHECK ADD  CONSTRAINT [FK_Paper_User_] FOREIGN KEY([username])
REFERENCES [dbo].[User_] ([username])
GO
ALTER TABLE [dbo].[Paper] CHECK CONSTRAINT [FK_Paper_User_]
GO
