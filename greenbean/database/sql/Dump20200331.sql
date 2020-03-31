-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: greenbean
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_author`
--

DROP TABLE IF EXISTS `t_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_author` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作者id',
  `name` varchar(100) DEFAULT 'null' COMMENT '作者名字\\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='作者';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_author`
--

LOCK TABLES `t_author` WRITE;
/*!40000 ALTER TABLE `t_author` DISABLE KEYS */;
INSERT INTO `t_author` VALUES (1,'牛津大学'),(2,'程杰'),(3,'布兰登•罗伊尔'),(4,'乔斯坦·贾德'),(5,'D·Q·麦克伦尼'),(6,'理查德·格里格'),(7,'菲利普·津巴多'),(8,'理查德·道金斯'),(9,'理查德·普雷斯顿'),(10,'G.伽莫夫'),(12,'吴军'),(13,'G.伽莫夫'),(14,'沃尔特·沙伊德尔'),(15,'约瑟夫·米森 文'),(16,'爱德华·斯诺登'),(17,'萨缪·希提 绘'),(18,'Ann Cook'),(19,'李淼'),(20,'汪民安'),(21,'郭晓彦'),(22,'亨利·H.衡'),(23,'沈大成'),(24,'Sönke Ahrens'),(25,'马里奥·巴尔加斯·略萨'),(26,'若泽·爱德华多·阿瓜卢萨 José Eduardo Agualusa');
/*!40000 ALTER TABLE `t_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_authority`
--

DROP TABLE IF EXISTS `t_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_authority` (
  `user_id` int(11) NOT NULL COMMENT '用户ID，参照t_user表用户ID字段',
  `authority` varchar(45) NOT NULL COMMENT '权限',
  PRIMARY KEY (`user_id`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_authority`
--

LOCK TABLES `t_authority` WRITE;
/*!40000 ALTER TABLE `t_authority` DISABLE KEYS */;
INSERT INTO `t_authority` VALUES (1,'ADMIN'),(2,'ADMIN'),(3,'user'),(4,'user'),(5,'user'),(6,'user'),(7,'user'),(8,'user'),(9,'user'),(10,'user'),(11,'user'),(12,'user'),(13,'user'),(19,'user'),(20,'user'),(21,'user'),(22,'user'),(23,'user'),(24,'user'),(25,'user'),(26,'user'),(27,'user'),(28,'user'),(29,'user');
/*!40000 ALTER TABLE `t_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book`
--

DROP TABLE IF EXISTS `t_book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'book_id',
  `name` varchar(100) DEFAULT NULL COMMENT '书名\\\\n',
  `isbn` varchar(45) DEFAULT NULL COMMENT 'ISBN码\n',
  `picture` varchar(45) DEFAULT NULL,
  `publisher` varchar(45) DEFAULT NULL COMMENT '出版社',
  `publish_year` int(4) DEFAULT NULL COMMENT '出版日期-年\\n',
  `publish_month` int(2) DEFAULT NULL COMMENT '出版日期-月\\n',
  `publish_day` int(2) DEFAULT NULL COMMENT '出版日期-日',
  `price` float DEFAULT NULL COMMENT '价格',
  `subtitle` varchar(100) DEFAULT NULL,
  `original_name` varchar(1000) DEFAULT NULL,
  `binding` int(1) DEFAULT NULL,
  `page` int(4) DEFAULT NULL,
  `content_intro` varchar(3000) DEFAULT NULL,
  `author_intro` varchar(3000) DEFAULT NULL,
  `directory` varchar(3000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `isbn_UNIQUE` (`isbn`),
  UNIQUE KEY `picture_UNIQUE` (`picture`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='book';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book`
--

LOCK TABLES `t_book` WRITE;
/*!40000 ALTER TABLE `t_book` DISABLE KEYS */;
INSERT INTO `t_book` VALUES (1,'大话数据结构','9787302255659','data structure.jpg','清华大学出版社',2011,6,0,59,'','',1,440,'本书为超级畅销书《大话设计模式》作者程杰潜心三年推出的扛鼎之作！以一个计算机教师教学为场景，讲解数据结构和相关算法的知识。通篇以一种趣味方式来叙述，大量引用了各种各样的生活知识来类比，并充分运用图形语言来体现抽象内容，对数据结构所涉及到的一些经典算法做到逐行分析、多算法比较。与市场上的同类数据结构图书相比，本书内容趣味易读，算法讲解细致深刻，是一本非常适合自学的读物。','一个被读者誉为很适合写IT技术书的家伙。《大话设计模式》作者。此书07年末出版至今已经简体版印刷9次、繁体版印刷6次，取得了较好的成绩，开创了一种适合国人阅读的趣味讲解IT知识的风格模式。其本人参与过政府、证券、游戏、交通等多种行业的软件开发及项目管理工作，也曾做过软件培训的教师。因曾有过两年半高中数学教学的独特经历，使得其书作当中处处以初学者视角考虑和分析问题，他成为了当前很受欢迎的IT技术图书作者之一。','第1章数据结构绪论 '),(2,'一本小小的蓝色逻辑书','9787510844287','logic.jpg','九州出版社',2016,8,1,39.8,NULL,NULL,2,244,'大约两千五百年前，苏格拉底创建了一套方法，通过一系列探问，也就是后世所说的“苏格拉底方法”，来获取问题的答案，并对这些答案进行推断。通过这种方式，他就可以找出各种复杂现象背后的关键问题，揭开很多貌似有理实则荒谬的说法背后的真相。这套方法就是后来我们所说的“逻辑推理”\n\n本质上来说，逻辑推理是一个“收集信息、评估信息的过程”。要想做出正确的决定，我们首先要占有充分的信息，而要想占有充分的信息，首先需要提出正确的问题。所以那些擅长逻辑推理的人，往往也比较善于提问，搜集相关信息，并用“正确的”方式 对这些信息进行评估。最重要的是，他们可以在不受他人干扰的情况下独立完成这一过程。\n\n本书的目的，就是为读者提炼出一套最有用、最完整的逻辑推理概念，帮助读者在学习和现实生活中更好地理清思路，解决问题。\n\n','布兰登•罗伊尔，出生于加拿大，就读于哈佛大学，后在考试培训机构Kaplan担任主管。其作品先后五次荣获“国际图书奖”、五次荣获“总统图书奖”金奖，2011年荣获“年度教育图书奖”。\n\n任职于Kaplan期间，他潜心研究英文写作、语法和逻辑推理教学，总结自己多年的教学经验，独创了一整套教学体系，并先后出版了《一本小小的蓝色逻辑书》、《一本小小的红色写作书》、《一本小小的金色语法书》等经典著作，成为全球英文写作、语法、逻辑推理领域的标杆之作。','前言 / 01\n引言 / 03\n第1章 感知和思维模式\n选择性感知 / 003\n世上到底有没有“偶然现象”这回事？ / 005\n四种典型思维方式 / 007\n第2章 如何进行创意思考\n水平思考法 / 015\n发散性思维与聚合性思维 / 020\n思维导图 / 024\n魔鬼代言人 / 027\n点子杀手和点子孵化器 / 028\n头脑风暴 / 033\n重述问题 / 038\n推销创意 / 040\n第3 章 如何做决策\n利弊分析法 / 046\n矩阵分析法 / 051\n决策树 / 060\n概率树 / 063\n加权排序法 / 065\n效用分析法 / 070\n沉没成本 / 073\n假设测试法 / 074\n囚徒困境 / 081\n第4 章 如何进行论述分析\n什么是论述 / 088\n分析论述 / 089\n五个常见的推理漏洞 / 094\n逻辑推理大练兵 / 106\n第5 章 掌握逻辑\n“只要……就……”陈述 / 122\n“NSMA”陈述 / 124\n相互独立，完全穷尽 / 126\n逻辑等同陈述 / 127\n逻辑推理大练兵 / 129\n附录\n附录Ⅰ 逻辑漏洞 / 137\n附录Ⅱ 避免不恰当的推论 / 145\n附录Ⅲ 类比 / 147\n附录Ⅳ 如何做决定：10 个常见权衡取舍思考 / 152\n附录Ⅴ 阅读理解 / 159\n附录Ⅵ 阅读理解解题技巧 / 163\n附录Ⅶ 题目解答 / 176'),(3,'苏菲的世界','9787506341271','sophie\'s world.jpg','作家出版社',2007,10,NULL,26,NULL,'Sofies verden',2,528,'这本书以小说的形式，通过一名哲学导师向一个叫苏菲的女孩传授哲学知识的经过，揭示了西方哲学发展的历程。由前苏格拉底时代到萨特，以及亚里士多德、笛卡儿、黑格尔等人的思想都通过作者生动的笔触跃然纸上，并配以当时的历史背景加以解释，引人入胜。评论家认为，对于那些从未读过哲学课程的人而言，此书是最为合适的入门书，而对于那些以往读过一些哲学而已忘得一干二净的人士，也可起到温故知新的作用。\n\n14岁的少女苏菲不断接到一些极不寻常的来信，世界像谜团一般在她眼前展开。在一位神秘导师的指引下，苏菲开始思索，她运用少女天生的悟性与后天知识，企图解开这些谜团。然而，事实真相远比她所想的更怪异、更离奇……','乔斯坦·贾德，1952年生于挪威，担任高中哲学教师多年，以《苏菲的世界》一书，奠定全球知名畅销作家的地位；执著于人的本质与人生终极意义的探索与思考；设立挪威环境与发展奖项——“苏菲奖”。','伊甸园　在某个时刻事物必然从无到有\n魔术师的礼帽　要成为一个优秀的哲学家只有一个条件：要有好奇心\n神话　善与恶之间脆弱的平衡\n自然派哲学家　没有一件事物可以来自空无\n德谟克里特斯　世界上最巧妙的玩具\n命运　算命者试图预测某些事实上极不可测的事物\n苏格拉底　最聪明的是明白自己无知的人\n雅典　废墟中升起了几栋高楼\n柏拉图　回归灵魂世界的渴望\n少校的小木屋　镜中的女孩双眼眨了一眨\n亚理斯多德　一位希望澄清我们观念的严谨的逻辑学家\n希腊文化　一丝火花\n明信片　我对自己实施严格的检查制度\n两种文化　避免在真空中飘浮的唯一方式\n中世纪　对了一部分并不等于错\n文艺复兴　啊！藏在凡俗身躯里的神明子孙哪\n巴洛克时期　宛如梦中的事物\n笛卡尔　他希望清除工地上所有的瓦砾\n斯宾诺莎　上帝不是一个傀儡戏师傅\n洛克　赤裸、空虚一如教师来到教室前的黑板\n休姆　将它付之一炬\n柏克莱　宛如燃烧的恒星旁一颗晕眩的行星\n柏客来　曾祖母向一名吉普赛妇人买的一面古老魔镜\n启蒙　从制针的技术到铸造大炮的方法\n康德　头上闪烁的星空与心中的道德规范\n浪漫主义　神秘之路通向内心\n黑格尔　可以站得住脚的就是有道理的\n祁克果　欧洲正迈向破产的地步\n马克思　在欧洲游荡的幽灵\n达尔文　满载基因航行过生命的一艘小船\n佛洛伊德　他内心出现那股令人讨厌的自大的冲动\n我们这个时代　人是注定要受自由之苦的\n花园宴会　一只白色的乌鸦\n对位法　两首或多首旋律齐响\n那轰然一响　我们也是星尘'),(4,'简单的逻辑学','9787213055386','being logical.jpg','浙江人民出版社',2013,6,1,29.9,NULL,'Being Logical: A Guide to Good Thinking',2,156,'这是一本足以彻底改变你思维世界的小书。美国著名逻辑学家、哲学教授D.Q.麦克伦尼，将一门宽广、深奥的逻辑科学以贴近生活、通俗易懂、妙趣横生的语言娓娓道来。它既没有刻板的理论教条，也不是正规的教科书，而是一本必不可多得的现实指南。正如著名行为学家孙路弘所说： 《简单的逻辑学》就如一场及时雨，一本治愈社会疾病的宝典，的确是应该人手一册。\n\n作者在书中告诉我们，生活中，逻辑无处不在。无论我们是有意还是无意，逻辑无时不在服务于我们的生活。然而逻辑到底是什么，也许并没有太多的人有很清楚的概念。作者以其简练而又充满趣味的笔触，将逻辑学活化为一种艺术，从它的基本原理，到论证，到非逻辑思维的根源，再到28种就发生在你身边的非逻辑思维形式，带领我们进入这个精彩无比的逻辑世界，体会妙趣横生的思维交锋，跨过无处不在的逻辑陷阱，让你沉醉其中，欲罢不能。\n\n[编辑推荐]\n\n《简单的逻辑学》作为最畅销的逻辑学科普入门书，被香港中文大学奉为40本英文经典之一，被哈佛大学校内书店视为皇冠书籍，还曾位列台湾诚品网络书店英文畅销书榜第一名，同时，还是国内最畅销、读者热评近2万条的五星好书，本书再经湛庐文化策划出品，重磅回归。\n\n这是一本足以彻底改变你思维世界的小书。正如著名行为学家孙路弘所说：缺乏逻辑已成为社会的一种流行病症：逻辑紊乱症候群。而《简单的逻辑学》就如一场及时雨，一本治愈社会疾病的宝典，的确是应该人手一册。\n\n作者D.Q.麦克伦尼在书中提出了28种非逻辑思维形式，抛却了逻辑学一贯的刻板理论，转而以轻松的笔触带领我们畅游这个精彩无比的逻辑世界，让你沉醉其中，欲罢不能。\n\n湛庐文化出品',' 美国著名逻辑学家、哲学教授，从事教学多年，曾先后任教于圣母大学和肯塔基大学。现居住于内布拉斯加州林肯市。\n\n 他说，如果读者因为这本小书而对逻辑学有更多了解，我将非常欣慰，尤其是书中提出的28种非逻辑思维形式，更是体现了生活中无处不在的逻辑陷阱：\n\n 稻草人谬误\n\n 对人不对事\n\n 滥用专家意见\n\n 以出身论英雄\n\n 以笑饰非\n\n 以泪掩过\n\n……','推荐序 学点逻辑\n孙路弘 著名行为学家、系列畅销书《用脑拿订单》作者\n前言\n第1章 学习逻辑学的思想准备\n1.全神贯注\n2.确认事实\n3.观念与其对象\n4.留意观念的本源\n5.观念联系事实\n6.将观念付诸语言\n7.有效沟通\n8.避免使用模糊和多义的语言\n9.避免闪避式语言\n10.真相\n第2章 逻辑学的基本原理\n1.基本原理\n2.灰色地带及人为灰色地带\n3.万物终有其根源\n4.对原因的探寻不要半途而废\n5.区分原因\n6.定义术语\n7.直言命题\n8.普遍命题\n第3章 论证：逻辑学的语言\n1.建立一个论证\n2.从全称到特称\n3.从特称到全称\n4.断言\n5.否定命题\n6.比较\n7.比较和论证\n8.正确论证\n9.条件论证\n10.三段论\n11.前提的真实性\n12.前提的相关性\n13.事实命题，价值命题\n14.论证结构\n15.结论必须反映前提的量\n16.结论必须反映前提的质\n17.归纳论证\n18.评定论证\n19.构造一个论证\n第4章 非逻辑思维的根源\n1.怀疑论\n2.逃避性不可知论\n3.玩世不恭和盲目乐观主义\n4.眼界狭窄\n5.情感和论证\n6.推理的原因\n7.论证不是争吵\n8.真诚的局限性\n9.常识\n第5章 非逻辑思维的主要形式\n1.否定前件\n2.肯定后件\n3.中项不周延\n4.偷换概念\n5.窃取论题\n6.虚假假设\n7.稻草人谬误\n8.误用传统\n9.以暴易暴\n10.民主谬误\n11.对人不对事\n12.压制理性\n13.滥用专家意见\n14.质的量化\n15.以出身论英雄\n16.止于分析\n17.简化主义\n18.分类错误\n19.混淆视听\n20.以笑饰非\n21.以泪掩过\n22.无力反驳不算证明\n23.两难陷阱\n24.以先后论因果\n25.情感误导\n26.功利误导\n27.避免结论\n28.简化推理\n译者后记'),(5,'牛津少年儿童百科全书（上、下编）','9787538249163','children\'s Encyclopedia.jpg','辽宁教育出版社',2001,1,NULL,280,NULL,'Oxford Children\'s Encyclopedia',1,999,'《牛津少年儿童百科全书(套装共9册)》共9卷。第1卷到第7卷知识广泛，内容应有尽有，包含最新资料；第8卷收554名人传记，当代人物、历史人物俱全；各词条既保留英文字母次序排列，又有中文索引，一举两得；索引共15,000条，可据笔划序检索；精心编排，书中图文互见贯通，培养儿童少年查阅资料的能力；彩色插图3000幅，照片2000幅，图文并茂，相辅相成；提供世界最高难度纪录、统计数字等资料，趣味盎然。\n\n这几年国内出了不少以少年儿童为对象的百科全书，辽宁教育出版社、牛津大学出版社联合出版的《牛津少年儿童百科全书》（中文版，1998年出版，以下作《牛津》）是比较有特色的。该书据英文版的 1996年新版翻译而成，该书原名：Oxford Children\'s Encyclopedia,全书 9卷。l—8卷为正文，第9卷为索引。精美的图画，精心的装演，精致的印刷，让人觉得这好象是一件印刷工艺品。细读之后，更觉得这是一套在内容上也很成功的少儿类百科全书，在教育思想、编纂原则与方法上都给我们提供了许多启发。\n\n“Encyclopedia( 百科全书)一词源自希腊文，意思是‘全面教育’。《牛津少年儿童百科全书》旨在提供地理、科技、体育、历史、宗教、音乐、美术等各门学科和人物、消闲诸方面的基础知识，应有尽有，内容扎实。”（引自英文版序言）。一部百科全书就是编纂者在构建一个知识体系，包括了少年儿童应该掌握的知识内容及范围。《牛津少年儿童百科全书》在词条的选择上，形成了一个与中国人传统视野范围不同的知识体系。书中许多词条是中国人还不很熟悉的，甚至显得比较冷僻，但仍向人们提供了一个值得去探知的知识世界。在世界进一步开放与交流的今天，世界正在变成“地球村”，是应该并可以形成一些人类共性知识的。可以说不掌握人类的基本共性知识就难以走出国门。\n\n全书2082个词条，收有大量关于自然与社会现象的词条，如“显花植物”、“史前动物”、“已绝种的动物”、“动物种群”、“供人食用的动物”、“有毒动物”、“生态”、“草原”、“乳汁”、“巢穴”、“灌溉”、““传说”、“传播媒体”、“记忆”、“变态”、“迁移”、“生产行业”、“工业革命”、“电的供应”、“卫生”、“催眠状态”、“体温过低”等。还有像“平面设计”、“图表”、“重力”这样的基本科学知识与术语。有些则是专门为少年儿童设计的，如“写信”、“验光师”等。展现了许多现在人们普遍关心的知识与问题，如“全球气候变暖”、“温室效应”、“恐龙”、“遗传工程”、“绿色运动”、“电脑”、“信息技术”、“国际互联网络”、“脱氧核糖核酸”。\n\n作者并非纯客观地介绍这些知识，而是表现出一种对我们生活在其中的社会和生态环境的关心。譬如对环境与大自然的爱护，就在许多地方都有体现。或是将它们单独立目，如“已绝种的动植物”、“濒临绝种的物种”、“绿色运动”。或是在词条中专门列出一节进行论述，如“大象”条中列有“濒临灭绝的象”节；“食物”条中列有“粮食不足或过剩”节；“燃料”条中列有“更好地使用燃料”节；“荒地”条中列出“荒地的用途”节；“渔业”条中列有“过度捕捞”节；在“湿地”条中列出“对湿地的破坏”、“湿地保护海岸”、“湿地保护区”三节，指出“失去湿地不但摧毁了动植物的生境，对人类也会造成重大伤害”。在“钓鱼”条里的“保护生态”节中说得更细致：“应注意淡水鱼的禁渔期……。释放一定数量的鱼让人钓或把每人的钓鱼数只限于食用，也是保持鱼类数量的措施。……不要抛弃尼龙钓丝，因为这会缠住乌类；也不要用会毒害天鹅的铅球。钓粗鱼的人常用存鱼网储存钓到的鱼，离开前才放回水里。要留意不应让存鱼网过满，且应把网放在水深处，以免伤害鱼类。”或是通过匠心独具的图片来展现，如在“侵蚀”条安排了一幅泥土被侵蚀而寸草不长的荒山图，在“环境”条安排了一幅国家公园里因酸雨而枯死的云杉树图，都收到了触目惊心的效果。作者就是这样通过种种方式，在经意和不经意间，将对社会和生态的关心与爱护表达出来，对读者发挥着潜移默化的教育作用。\n\n介绍了许多其他国家和民族的民俗风情与物产物种。如“排灯节”是“印度教徒和锡克教徒为不同理由而庆祝的一个秋季节日”；“谒师所”是“锡克教徒用来作礼拜的地方”；“圆形石阵”是古人类所特有的一种垒石建筑，主要用于礼仪或宗教祭扫，存在于欧洲。“巴哈教徒”提到“巴哈教起源于19世纪的波斯，信徒几乎遍布全球”。又如对“毛鼻袋熊”、“树懒”、“指猴”、“袋狼”、“旅鸽”、“鸭嘴兽”、“负鼠”、“藤壶”、“叶蛙”、“海豹”、“浣熊’等均作介绍。这样的知识对国内读者来说是相当新鲜的。作者对自己的民族、历史与文化也作了较详细的介绍，如“西部乡村音乐”、“牛仔”、“十字军东征”、“拜占廷帝国”、“中世纪”、“路易九世”、“理查一世”、“萨拉丁”、‘“柳条艇”、“木栓”等。有关“基督教”的词目有不少，如“耶稣”、“圣诞节”、“复活节”、“大教堂”、“天使”、“使徒”、“中世纪”、“圣人”、“圣史剧”、“《圣经》”、“修道院”、“洗礼”、“教堂合唱团”、“骑士精神”、“救世军”、“葬礼”、“朝圣”、“赞美诗”、“魔王”、“天堂”、“地狱”、“教皇”、“宗教改革”、“新教徒”、“传教士”、“保罗”、“彼得”、“约翰”等。\n\n第八卷传记卷收有艺术家、作家、作曲家、文艺家、体育名星、世界政治家、统治者、宗教家、思想家、科学家、工程师、探险家、冒险家共554位。 《牛津少年儿童百科全书》在重点关照自己文化的同时，也尽量对其他民族的内容与特点有所反映；把对人类历史足迹的介绍与对当今世界的关注结合起来；把对社会的关心与对自然的爱护结合起来。看得出它在选取条目时，不是着重于学科知识的系统性，而是重在“需要认知”与“值得认知”的现象本身。这样的取舍原则符合青少年求知的需要和特点，构建了少年儿童所需的世界知识体系。',NULL,NULL),(6,'心理学与生活','9787115111302','psychology and life.jpg','人民邮电出版社',2003,10,NULL,88,NULL,'Psychology and Life',1,621,'《心理学与生活》是美国斯坦福大学多年来使用的教材，也是在美国许多大学里推广使用的经典教材，被ETS推荐为GRE心理学专项考试的主要参考用书，还是被许多国家大学的“普通心理学”课程选用的教材。这本教科书写作流畅，通俗易懂，深入生活，把心理学理论与知识联系人们的日常生活与工作，使它同样也成为一般大众了解心理学与自己的极好读物。\n\n作为一本包含着丰富的教育思想和独特教学方法的成熟教材，原书中所有元素——如由600余条词汇及解释组成的“专业术语表”，2000余条“参考文献”，以及近1000条的“人名和主题索引”等等，对于教学、研究和学习都十分宝贵，此中译本完整地翻译和保留了这些资料。','理查德·格里格（Richard J. Gerrig）是美国纽约州立大学的心理学教授。获Lex Hixon社会科学领域杰出教师奖。在认知心理学研究领域有专长，是美国心理学会实验心理学分会的会员。从《心理学与生活》这部经典教科书第14版修订时开始，格里格成为该书的合著者。\n\n菲利普·津巴多（Philip G. Zimbardo）是美国斯坦福大学的心理学教授，当代著名心理学家，美国心理学会主席。40多年来，由于他在心理学研究和教学领域的杰出贡献，美国心理学会特向津巴多频发了Hilgard普通心理学终生成就奖。由他开创的《心理学与生活》这部经典教科书哺育了一代又一代心理学工作者。津巴多主动让贤，推举格里格为《心理学与生活》第16版的第一作者。','序言\n第一章 生活中的心理学\n第二章 心理学的研究方法\n第三章 行为的生物学基础\n第四章 感觉\n第五章 知觉\n第六章 心理，意识和其他状态\n第七章 学习与行为分析\n第八章 记忆\n第九章 认知过程\n第十章 智力与智力测验\n第十一章 人的毕生发展\n第十二章 动机\n第十三章 情绪、压力和健康\n第十四章 理解人类人格\n第十五章 心理障碍\n第十六章 心理治疗\n第十七章 社会过程与关系\n第十八章 社会心理学，社会和文化'),(30,'American Accent Training','9781438071657','American Accent Training.jpg',' Barron\'s Educational Series, Incorporated',2012,9,1,39.99,'3rd edition','American Accent Training',1,224,'The world\'s best selling accent and pronunciation book. This book starts at the most basic level -- the syllable -- and builds up to the complex intonation that is used in everyday English. This book will guide you to fluency in spoken American English. All aspects of the American accent are covered in detail -- intonation, liaisons and pronunciation.\n\nThe new and expanded 3rd edition (September 2012) has four all-new chapters that cover the psychology of accent acquisition, American voice quality, a pronunciation overview, and an ESL instructor\'s guide. The new CDs feature professional male and female voices that have been carefully selected to represent that perfect American accent. With 30 years of extensive research, the unique AAT methodology has been refined to teach the American sound quickly and easily, paying special attention to:\n\n• Voice quality, with emphasis on accurate presentation of the authentic American sound\n\n• Pronunciation, with attention to all vowels, consonants, blends, and diphthongs\n\n• Intonation, which focuses on syllable stress rules and word stress in a sentence\n\n• Linking, or liaisons between phonetically transcribed sounds so students can \"see\" the sound\n\nAmerican Accent Training also offers detailed nationality guides for ten languages and accent variations: Chinese, Japanese, Indian, Spanish, French, German, Russian, Korean, Arabic, and the US Southern accent. Added features include access to comprehensive websites, and referral to a qualified telephone analyst for individual help. American Accent Training has been Americanizing the speaking habits of students and business people since 1991. Going where no accent book has gone before, AAT continues to set the standard for anyone learning or teaching the American accent.','Ann Cook is the author of the best-selling American Accent Training text, published by Barron\'s in 1991, 2000 and 2012. (Also published in China, Japan, Korea and India.) Her speciality is tailoring and expanding materials for specific situations, as in her three books for parents of elementary-age students, How Well Does Your Child Read? How Well Does Your Child Write? How Well Does Your Child Do Math?\n\nCook studied Spanish Literature at the California State University at Los Angeles, spent a year at the Institut d\'Études Françaises in Aix-en-Provence, a month studying Spanish with the Peace Corps language program in Quetzaltenango, Guatemala, and five years in Japan at the Japanese Culture and Language Institute in Tokyo.\n\nIn addition to her regular teacher training, Cook has trained a dozen Americans to teach in Korea, and hundreds of Korean high school students who came to the US for her program. Her company, American Accent Training, Inc., has provided training for numerous heads of corporations, post-graduate students, engineers and IT personnel. American Accent Training is used around the world at public and private schools, universities and corporate training programs.\n\nCook also developed an online learning program for the American accent and culture for blended learning in the overseas call center market, including assessments, industry-specific modules, sales modules, and general cultural information, delivered via a Moodle platform.\n\nAmerican Accent Training, Inc., founded in 1986 and incorporated in 1997, is a virtual language training company with instructors across the United States. All AAT instructors have a masters degree or PhD and are intensively trained in-house, specifically for second accent acquisition.','Introduction: Read This First\nPreliminary Diagnostic Analysis\nChapter 1 The American Sound\nVoice Quality\nIntonation and Attitude\nChapter 2 Psycholinguistics\nChapter 3 General Pronunciation\nChapter 4 American Intonation\nChapter 5 Syllable Stress\nChapter 6 Complex Intonation\nTwo-word Phrases\nChapter 7 Phrasing\nChapter 8 The Miracle Technique\nChapter 9 Grammar in a Nutshell\nChapter 10 Reduced Sounds\nChapter 11 Word Connections\nChapter 12 Cat? Caught? Cut?\nChapter 13 Tee Aitch\nChapter 14 The American T\nChapter 15 The American R\nChapter 16 The El\nChapter 17 S or Z?\nMid-point Diagnostic Analysis\nChapters 1-17 Review and Expansion\nChapter 18 More Reduced Sounds\nChapter 19 “V” as in Victory\nChapter 20 Tense and Lax Vowels\nChapter 21 The Ridge\nChapter 22 Grammar in a Bigger Nutshell\nChapter 23 Practical Application\nChapter 24 Nasal Consonants\nChapter 25 Throaty Consonants\nFinal Diagnostic Analysis\nNationality Guides\nAnswer Key\nTeacher\'s Guide\nIndex'),(31,'给孩子讲地外文明','9787571004927','给孩子讲地外文明.jpg','湖南科技出版社',2020,2,15,49,'大物理学家李淼教授讲给孩子的前沿物理学',NULL,1,160,'这是物理学家李淼写给孩子的关于地外文明的科普读物。在本书中，淼叔以生动有趣的方式回答了孩子们常常会好奇的问题，那就是：到底存不存在外星人？如果存在，他们在哪里，长什么样？淼叔从我们的猜想开始，讲述了智慧生命存在的条件与发展的历史，以及人类在探索地外文明方面的努力与进展；以坚实的科学知识，回应人类的狂野想象。','李淼，理论物理学家、畅销科普作家、文津图书奖得主。1982年毕业于北京大学天体物理专业，1984年获中国科技大学理学硕士学位。1989年赴丹麦哥本哈根大学玻尔研究所学习，1990年获哲学博士学位。1990年起先后在美国加州大学圣塔芭芭拉分校、布朗大学任研究助理教授，1996年在芝加哥大学费米研究所任高级研究助理。1999年回国，任中国科学院理论物理研究所研究员、博士生导师。2013年赴中山大学筹建天文与空间科学研究院并任院长。现为南方科技大学教授。身为大物理学家的李淼也活跃于科普领域，作品深受读者欢迎，屡获大奖。代表作有《给孩子讲量子力学》《给孩子讲宇宙》《给孩子讲相对论》《给孩子讲时间简史》《〈三体〉中的物理学》等。','第1 讲 我们对外星人有多少猜想\n第2 讲 地球是如何发展出智慧生命的\n第3 讲 生命的出现需要什么条件\n第4 讲 我们在地球之外找到了什么'),(32,'癌症思辨——癌症研究中的悖论','9787535290366','癌症思辨.jpg','湖北科技出版社',2016,11,1,55,'癌症研究中的悖论','癌症思辨',2,372,'本书介绍了癌症演变基因组理论这一新概念，以求一统研究领域。许多重要和具有代表性的但又容易产生疑惑的问题和悖论将在本书中进行批判性分析。通过比较基因和基因组理论，许多普遍流行观念中所隐藏的缺陷得以阐释。本书的讨论旨在抛砖引玉以启动对当前癌症研究的批判性重新评估，这是当前研究形式下迫切需要的一场思辨！','亨利·H.衡（Henry H.Heng）博士，毕业于美国维恩州立大学。主攻专业领域：分子生物学，细胞生物学。','第1章引言：为何此时以及为何围绕癌症展开思辨 第2章癌症的基因突变理论第4章癌症基因组测序计划揭示出意料之外的癌症基因组全貌\r \n第5章揭开癌症之谜：理解基因组变异介导的癌症演变\n第6章不重要之中的重要性：为何“噪音”对于癌症演变而言是不可或缺的\r \n第7章不同类型的癌症是否代表不同的物种\r \n第8章事实与江湖传言\n参考文献\n后记\n缩略语列表'),(34,'生产（第7辑）','9787214069825','生产（第7辑）.jpg','江苏人民出版社',2011,6,1,39,'生命政治：福柯、阿甘本与埃斯波西托',NULL,1,324,'《生产(第7辑):生命政治:福柯、阿甘本与埃斯波西托》讲述了对于“生产”的关注，源自马克思主义传统，正是在生产环节，马克思发现了资本增殖的秘密。马克思之后，“生产”获得更丰富的内涵：文化领域是知识生产，精神领域是欲望生产，政治领域是权力生产，社会变成一个巨大的生产机器——而所谓“消费社会”不过是它的一个反讽性注释。“生产”，成为诊断当代社会的关键词。另一方面，“生产”这个词对于今日中国人而言似乎别具意味：我们曾经身陷“生产”之笼，如今，我们期待这个迷失在历史深处的词语重新获得活力。当然，词语自有其命运，我们所能做的也只是邀请。最后，需要指出的是，“生产”的内在语义，就是生成，流变，活力，它符合当代知识分子的气质：永不停息地思考和批判。正是在这个意义上，“生产”是批判和思想的基本特征。','authorIntro','专题：生命政治：福柯、阿甘本\n生命政治的诞生 米歇尔· 福柯\n全体与单一：走向政治理性批判 米歇尔·福柯\n紧急状态 吉奥乔·阿甘本\n生命政治与主体性 吉奥乔· 阿甘本\n在人权之外 吉奥乔·阿甘本\n形式生命 吉奥乔·阿甘本\n阿甘本访谈录 乌尔利希·豪尔夫\n生命政治及其他：论福柯的一个重要理论之流布 托马斯·拉姆克\n生命权力：福柯与阿甘本 凯特·吉拉尔\n对当前生命权力概念的思考 保罗·拉比诺 尼克拉斯·罗斯\n阿甘本：法与生命的神圣性 米格尔·法特\n从生命政治角度看尼采的犯罪哲学 弗里德里希·巴尔克\n吉奥乔·阿甘本和卡尔·施密特的政治浪漫主义和生命政治 弗德里克·卢赛蒂\n保护政治学 萨缪尔·韦伯\n纯粹的内在性：一种生命 吉尔·德勒兹\n人物：罗伯托·埃斯波西托 (Roberto Esposito)\n1,免疫范式 罗伯托·埃斯波西托\n2, 免疫与暴力 罗伯托·埃斯波西托\n3,免役式民主 罗伯托·埃斯波西托\n4,尼采、生命政治与动物性生存问题 瓦内萨·列姆\n5,罗伯托·埃斯波西托访谈录 坎贝尔\n评论\n瓦尔特·本雅明：历史断片与文学批评 曹雷雨\n艺术\n新世纪中国艺术的八个关键形象 郭晓彦\n文献\n欲望及对《哈姆雷特》中欲望的阐释 雅克·拉康'),(36,'小行星掉在下午','9787559823144','小行星掉在下午.jpg','理想国 | 广西师范大学出版社',2020,NULL,NULL,54,NULL,NULL,2,296,'闪烁着霓虹灯的疫区，墨鱼人藏身的超大型地铁站，逐步变异的公司职员，新星球上建设社会的伟大历程……本书是沈大成新近创作的短篇小说精选，作者以其独有的黑色幽默，塑造了一群仿佛生活在地球的双生星上的人类，并将他们置于不确定的未来即将落下的时刻。\n\n一个异质而又有其自身逻辑的世界，读者既可将之看作愉快的脑内小革命，也难以忽视其中现实主义的一面。而我们当代生活的一部分特质，就在沈大成小说独特的显影法下逐步显现。','沈大成，作家，文学杂志编辑，在《萌芽》杂志开设有短篇小说专栏“奇怪的人”。著有短篇小说集《屡次想起的人》。首届宝珀理想国文学奖决选名单作者。','1 世上最美的电影明星\n17 配音演员\n36 次级\n49 实习生\n83 工作狂\n104 在世界末日兜风\n117 盒人小姐\n138 墨鱼人\n158 海边的女人\n169 夹克男\n200 使喂养人害怕的猫\n212 男孩托托\n230 黑鸟\n248 一个中性事件\n259 星际迷航中的一件小事\n271 星际迷航中的另一件小事'),(37,'不平等社会','9787521704495','不平等社会.jpg','中信出版集团股份有限公司',2019,6,1,98,'从石器时代到21世纪,人类如何应对不平等','The Great Leveler: Violence and the History of Inequality from the Stone Age to the Twenty-First Century',2,528,'自从人类开始耕种、放牧，并把财产代代相传，经济不平等就一直是人类文明的显著特征。进入21世纪后，贫富差距在世界范围内不断扩大，经济不平等问题越发突出，甚至已经影响全球稳定。\n\n美国知名历史学家沃尔特·沙伊德尔回溯从石器时代到今天的经济史，从长远的时间维度追寻和解释经济不平等。他从最早的文明危机谈到20世纪的灾难性世界战争、革命，颠覆性地指出经济不平等从不会悄然消失，大规模暴力和灾难才能够显著改变这一切，换言之，只有战争、革命、瘟疫和国家崩溃才能重新洗牌。\n\n沙伊德尔进一步强调，几千年来，文明社会并没有让自己适应和平的平等化进程，我们需要问自己，人类文明的成果是如何分配的，是什么原因使得它们以这样的方式被分配，以及将要采取什么措施来改变这些结果。\n\n沙伊德尔的观点也许激进而尖锐，存在争议，但无论你是否认同，愈演愈烈的收入不平等问题是包括中国在内的大多数国家所面临的重大挑战，《不平等社会》将帮助我们审视人类的不平等史，探寻人类命运的可能，从而更好地应对未来。','沃尔特·沙伊德尔(Walter Scheidel)，美国斯坦福大学人文学科迪卡森讲席教授、古典学和历史学教授，人类生物学系的肯尼迪-格罗斯曼研究员，是当前国际古希腊、古罗马史研究领域最重要、最活跃的学者之一。\n\n沙伊德尔已经出版了十几部著作，包括《罗马与中国》《剑桥希腊罗马经济史》等，并在前现代社会和经济史、人口统计学和比较史学等领域发表了大量文章。','序 言 不平等的挑战\n第一部分 不平等简史\n第1章 不平等的起源\n第2章 不平等的帝国\n第3 章 大起大落\n第二部分 战争\n第4章 全面战争\n第5章 大压缩\n第6章 前工业化时期的战争和内战\n第三部分 革命\n第7章 共产主义\n第8章 前列宁时代\n第四部分 崩溃\n第9 章 国家衰败和系统崩溃\n第五部分 灾难\n第10章 黑死病\n第11章 瘟疫、饥荒和战争\n第六部分 替代性选择\n第12 章 改革、衰退及表现\n第13 章 经济发展和教育\n第14 章 如果是另一种历史，那会怎么样呢？\n从历史到反事实分析\n第七部分 不平等的卷土重来和未来的不平等矫正\n第15 章 在我们这个时代\n第16 章 未来将何去何从？\n附 录 不平等的极限\n致 谢\n注 释\n参考文献\n译后记'),(39,'How to Take Smart Notes','9781542866507','How to Take Smart Notes.jpg','CreateSpace Independent Publishing Platform',2017,2,24,11.99,'CreateSpace Independent Publishing Platform','One Simple Technique to Boost Writing, Learning and Thinking – for Students, Academics and Nonfiction Book ',1,176,'The key to good and efficient writing lies in the intelligent organisation of ideas and notes. This book helps students, academics and nonfiction writers to get more done, write intelligent texts and learn for the long run. It teaches you how to take smart notes and ensure they bring you and your projects forward. The Take Smart Notes principle is based on established psychological insight and draws from a tried and tested note-taking-technique. This is the first comprehensive guide and description of this system in English, and not only does it explain how it works, but also why. It suits students and academics in the social sciences and humanities, nonfiction writers and others who are in the business of reading, thinking and writing. Instead of wasting your time searching for notes, quotes or references, you can focus on what really counts: thinking, understanding and developing new ideas in writing. It does not matter if you prefer taking notes with pen and paper or on a computer, be it Windows, Mac or Linux. And you can start right away.','Dr. Sönke Ahrens is a writer and researcher in the field of education and social science, author of the award winning book \"Experiment and Exploration. Forms of World-Disclosure\" (Springer) and university teacher for philosophy of education.','directory'),(40,'这就是物理','9787568270205','这就是物理.jpg','北京理工大学出版社',2019,7,NULL,200,'函套10册','Building Blocks of Physical Science',1,286,'大科学家带你一次看懂10大物理主题\n \n 入选美国学校图书馆期刊“*参考书”\n \n 中国工程院院士、著名物理学家周立伟 审读推荐\n \n 中国科学院高能物理所副研究员、博士靳松，北京理工大学物理学院副教授何建锋，北京市赵登禹学校物理教师张雪娣 全文审读\n \n 从身边生活入手，物理教学无缝链接，帮孩子轻松建立学科自信','',''),(41,'永久记录','9787513927277','permanent record.jpg','民主与建设出版社',2019,11,NULL,68,'美国政府监控全世界网络信息的真相','Permanent Record',1,320,'本书是爱德华•斯诺登的自传，记录了他在童年、少年、成年时期的经历，以及自己价值观变化的全部过程。书中内容既反映了现代网络科技的发展，也表现了作者对美国政府监视行为的不安，并表达了他内心深处的反思与告白。\r\n\r\n全书分为三个部分。第一部分是斯诺登的童年回忆。他自小开始对计算机程序语言产生浓厚的兴趣，并由此走上成为系统工程师之路，寻找网络的秘密。第二部分是斯诺登受雇于美国情报机构期间的经历。此期间，他冒着极大风险曝光美国政府的大规模监视系统。这一部分还讲到他为建立这个系统所做的工作，以及促使他曝光事件的原因。第三部分是斯诺登逃亡到香港和俄罗斯，联络媒体继续曝光整个事件的经历。在这一部分中，他也袒露了内心的矛盾。\r\n\r\n从田园诗般的童年印象，到跌宕起伏的情报工作，《永久记录》这本书讲述了斯诺登独特的人生经历，是关于这个“在网上长大”的聪明年轻人的完整而深刻的记录。他满怀着激情与坦率、智慧与担当写下的这本书，注定将成为数字时代不可忽略的嘹亮回声。','爱德华•斯诺登，1983年出生在北卡罗来纳州的伊丽莎白市，在马里兰州的米德堡长大。经训练，成为一位系统工程师，曾作为一名普通雇员就职于美国中央情报局，后成为美国国家安全局外包技术员。因2013年6月将美国国家安全局关于“棱镜计划”监听项目的秘密文档披露给英国《卫报》和美国《华盛顿邮报》，遭到英国和美国的通缉。随后，斯诺登前往俄罗斯，并在同年8月获得一年的临时政治避难，后延期至2020年。\r\n\r\n他因在公共服务方面的贡献而获得无数殊荣，包括瑞典“正确生活方式奖”、德国“揭秘者奖”、“瑞登奥尔揭发真相奖”、国际人权联盟“卡尔•冯•奥西茨基奖”。','原文摘录：\r\n“在学校，教科书告诉我们，美国民主体制的精髓在于“一人一票”，这就是民主。但显然，民主不存在于我的美国历史课堂，若是我们班上都能投票的话，那历史老师马丁先生肯定会失业。相反的，马丁先生为美国历史课堂设下规则，正如同英文老师伊凡斯太太、科学老师斯威尼先生与数学老师史塔克顿先生等人，这些老师经常更改规则以助益自己并扩大权力。若老师不希望你们上厕所，那你们最好先憋着。若老师取消带你们参访史密森尼学会的行程，那他们根本不必多做解释，只要拿出“权威不容挑战、秩序需要维护”的态度即可。在那时，我便体会到反对体制的困难，尤其是涉及到更改规则以符合多数人的需求，因为这有害于订定规则者的利益。这便是每个系统的重大缺点或设计瑕疵，不论是在政治或电脑领域皆然，换句话说，创造规则的人没有理由与自己作对。 我认为，学校是一个不合理的体制，因为它容不下任何合理的质疑。我可以据理力争直到精疲力尽，或是干脆接受现实，承认一开始就无权置喙。 但是，历史经验证明，学校这个看似仁慈的暴君终有被推翻的一天。否决学生独立思考的空间，将成为他们起身反抗的导火线，尽管许多青少年经常将抵抗与逃避或暴力混淆在一起。一般叛逆青少年发泄情绪的管道，对我来说根本没用，因为毁坏公物不是我的风格，而我又不敢尝试嗑药（直到今日，我仍没有酗酒或抽烟的经验）。相反的，我选择最聪明、最健康、最具教育性的方式，这是我所知道最能帮助青少年夺回自治权、与成年人平起平坐的方法，那就是骇客。”'),(42,'公羊的节日','9787532741243','公羊的节日.jpg','上海译文出版社',2009,8,NULL,39,'巴尔加斯·略萨作品系列',NULL,1,538,'阔别祖国三十五年的乌拉尼娅回到了故乡多米尼加共和国。三十五年前整个多米尼加共和国处于冷血独裁者特鲁希略的统治下，乌拉尼亚的父亲卡布拉尔正是这位独裁者的得力助手。三十五年后，卡布拉尔已老，他行动不便更是丧失了语言功能。乌拉尼娅的姑妈不能理解为何乌拉尼娅从不曾探望自己父亲，面对质问，乌拉尼娅缓缓诉说起三十多年前那些美好的回忆，那些政治阴谋，还有那个毁了她一生的秘密……\r\n\r\n多米尼加共和国前独裁者特鲁希略，这个被描绘为魔鬼的独裁者曾对三百多万多米尼加人施行了极端残酷的暴政，在他三十多年（1930－1961）的专制统治下，整个国家成了人间地狱。小说通过杜撰的一个女人的所见所闻，再现拉美最血腥的独裁统治。','马里奥·巴尔加斯·略萨（1936- ）当代文学大师，小说家、戏剧家和批评家，拉丁美洲作家的杰出代表。\r\n\r\n出生于秘鲁阿雷基帕。一九五九年，以《首领们》初获文名，一九六二年出版代表作《城市与狗》，又著有《绿房子》、《胡利娅姨妈与作家》、《公羊的节日》等多部小说，以及《塔克纳小姐》、《琼加》和《阳台上的疯子》等戏剧作品，二○○三年又有长篇新作《天堂在另外那个街角》问世。','一\r\n二\r\n三\r\n四\r\n五\r\n六\r\n七\r\n八\r\n九\r\n十\r\n十一\r\n十二\r\n十三\r\n十四\r\n十五\r\n十六\r\n十七\r\n十八\r\n十九\r\n二十\r\n二十一\r\n二十二\r\n二十三\r\n二十四'),(44,'遗忘通论','9787208163072',NULL,'世纪文景/上海人民出版社',2020,4,NULL,59,NULL,NULL,2,282,'☆ 《遗忘通论》获得2017年国际都柏林文学奖、2019年安哥拉国家文化艺术奖，入围2016年布克国际奖决选名单；\r\n\r\n☆ 阿瓜卢萨是当代安哥拉乃至整个葡语世界的代表作家，也是近年来竞逐诺贝尔文学奖的热门人选，《遗忘通论》已被翻译成25种语言出版，全球文学爱好者必读；\r\n\r\n☆ 《遗忘通论》是一个女人将自己“隔离”28年的故事，一部现代城市中的“鲁滨孙漂流记”，一段国家内战与身份建构的多舛命运；\r\n\r\n☆ 尽管《遗忘通论》展示了饥饿、酷刑和杀戮，它的基调与核心仍旧是爱，所有读者都能在这个故事中找到共鸣。\r\n\r\n☆ 阿瓜卢萨在《遗忘通论》中展现了高超的文学技巧，笔触既残酷又温暖，既厚重又轻盈。\r\n\r\n————————————————————————\r\n\r\n有些人练习遗忘，有些人害怕被遗忘，\r\n\r\n而有些人一直害怕别人永远忘不了他。\r\n\r\n内战开始后，一个女人出于恐惧，将自己关在家里28年，\r\n\r\n枪声、旗帜、街上的人群，她试图遗忘一切汹涌的怪物；\r\n\r\n死里逃生的葡萄牙雇佣兵说，遗忘就是死亡，就是投降；\r\n\r\n而血债累累的秘密警察因为自己被遗忘感到幸福……\r\n\r\n一张记忆的蛛网，一段动荡的历史，\r\n\r\n他们的命运在此交错，也将在梦里重新开始。\r\n\r\n—————————————————————————\r\n\r\n尽管《遗忘通论》展示了饥饿、酷刑和杀戮，它的基调与核心仍旧是爱……所有的读者都能在这个安哥拉的故事中找到共鸣。在阿瓜卢萨的蜂巢中，没有一个生命是孤立的，他也让读者相信，我们与这个世界紧紧相连。\r\n\r\n——国际都柏林文学奖评审委员会\r\n\r\n一段长达二十八年的“自我隔离”。一部城市中的“鲁滨孙漂流记”。一个国家多舛的建立与认同。阿瓜卢萨以绝妙的文笔与杰出的叙事技巧，带领我们进入一个陌生的世界，唤醒已被我们遗忘的理想，与理想背后的黑白底色。\r\n\r\n——闵雪飞\r\n\r\n如同葡萄牙作家佩索阿和阿根廷作家博尔赫斯，阿瓜卢萨技巧高超，他的虚构世界令人眼花缭乱……他是掌握多种体裁的大师，在侦探小说、田园牧歌和内心独白中转换自如，他向他笔下的人物倾注了饱满的热情，每个形象都生动地嵌入读者心中，呼唤着读者的同情与理解。\r\n\r\n——美国《星报》\r\n\r\n阿瓜卢萨无疑是讲故事的大师……他高超的叙事技巧，令笔下人物唤起了悲喜交集、身临其境的阅读体验。\r\n\r\n——美国《华盛顿独立书评》\r\n\r\n阿瓜卢萨已成为非洲葡语作家最杰出的声音之一，正如小说中一位人物所说，“有好故事的人简直就是国王”，阿瓜卢萨自己也能跻身非洲王者的行列。\r\n\r\n——英国《金融时报》','【作者】若泽·爱德华多·阿瓜卢萨（José Eduardo Agualusa）\r\n\r\n1960年出生于安哥拉，曾在葡萄牙学习农学和林学，作家、记者，著作颇丰，其作品已被翻译成25种语言出版。\r\n\r\n近年来，阿瓜卢萨在英语世界声名鹊起，成为当代安哥拉乃至整个葡语世界的代表作家。2007年凭借《贩卖过去的人》获英国《独立报》外国小说奖，是该奖设立以来首位获奖的非洲作家。《遗忘通论》入围2016年布克国际奖决选名单并获得2017年国际都柏林文学奖。\r\n\r\n【译者】王渊，文学博士，译有《所有的名字》《大象旅行记》等文学作品。','我们的天空是你们的地面\r\n小小死亡的哀歌\r\n不幸的士兵\r\n恐惧的本质\r\n结束之后\r\n“切· 格瓦拉”的非洲无花果树\r\n热雷米亚斯· 刽子手的第二次生命\r\n5 月27 日\r\n关于理智的打滑\r\n叛逆的天线\r\n日子像水一样滑过\r\n俳句\r\n意外的精巧设计\r\n失明（以及心的眼睛）\r\n收集失踪的人\r\n信\r\n幽灵之死\r\n关于上帝和其他微不足道的胡话\r\n驱魔\r\n卢多拯救罗安达的那一天\r\n显灵，和一次差点致命的坠落\r\n木提雅提树的布鲁斯\r\n本章会阐明一件失踪事件（接近两件），或是用马克思的话：“一切坚固的东西都烟消云散了”\r\n萨巴鲁的死人\r\n丹尼尔· 本希莫尔调查卢多的失踪\r\n木提雅提树的布鲁斯（2）\r\n库邦戈河的奇特终点\r\n本章揭晓纳赛尔· 埃万热利斯塔如何帮小酋长越狱\r\n罗安达的秘密\r\n蒙特之死\r\n相见\r\n一只名叫“爱”的鸽子\r\n热雷米亚斯· 刽子手的坦白\r\n事故\r\n最后的话\r\n一切在梦里开始\r\n致谢和参考书目\r\n阿瓜卢萨的虚构世界——代译后记');
/*!40000 ALTER TABLE `t_book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book_author`
--

DROP TABLE IF EXISTS `t_book_author`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book_author` (
  `book_id` int(11) NOT NULL COMMENT '书id',
  `author_id` int(11) NOT NULL COMMENT '作者id',
  PRIMARY KEY (`book_id`,`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book_author`
--

LOCK TABLES `t_book_author` WRITE;
/*!40000 ALTER TABLE `t_book_author` DISABLE KEYS */;
INSERT INTO `t_book_author` VALUES (1,2),(2,3),(3,4),(4,5),(5,1),(6,6),(6,7),(30,18),(31,19),(32,22),(34,20),(34,21),(36,23),(37,14),(39,24),(40,15),(40,17),(41,16),(42,25),(44,26);
/*!40000 ALTER TABLE `t_book_author` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book_translator`
--

DROP TABLE IF EXISTS `t_book_translator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book_translator` (
  `book_id` int(11) NOT NULL,
  `translator_id` int(11) NOT NULL,
  PRIMARY KEY (`book_id`,`translator_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book_translator`
--

LOCK TABLES `t_book_translator` WRITE;
/*!40000 ALTER TABLE `t_book_translator` DISABLE KEYS */;
INSERT INTO `t_book_translator` VALUES (2,5),(2,6),(3,4),(4,3),(6,1),(6,2),(13,3),(13,4),(15,3),(15,4),(16,2),(16,11),(24,1),(24,2),(27,1),(27,7),(32,12),(37,11),(40,10),(41,8),(41,9),(42,13),(44,14);
/*!40000 ALTER TABLE `t_book_translator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_book_user`
--

DROP TABLE IF EXISTS `t_book_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_book_user` (
  `book_id` int(11) NOT NULL COMMENT '书id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `type` smallint(1) DEFAULT NULL COMMENT '类型：reading:1，read:2',
  `score` smallint(2) DEFAULT NULL COMMENT '评分：1-10分',
  `time` datetime DEFAULT NULL,
  `comment` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`book_id`,`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_book_user`
--

LOCK TABLES `t_book_user` WRITE;
/*!40000 ALTER TABLE `t_book_user` DISABLE KEYS */;
INSERT INTO `t_book_user` VALUES (1,1,1,NULL,'2020-03-27 18:49:07','大话大话'),(1,2,2,8,'2020-03-14 10:29:52','好人卡'),(1,3,2,8,'2020-03-27 17:18:25','在这里'),(1,4,1,6,'2020-03-25 17:18:25','远方优势'),(1,5,1,8,'2020-03-14 10:29:52','坏人卡'),(1,6,2,2,'2020-03-26 17:18:25','好一个意义一样'),(1,7,2,10,'2020-03-24 20:18:25','真的吗'),(2,1,1,10,'2020-03-30 22:12:31',''),(2,2,2,8,'2020-03-27 11:14:24','再来一台哦'),(2,3,2,8,'2020-03-14 10:29:52','在哪里'),(2,4,2,10,'2020-03-14 10:29:52','天空糕'),(3,1,1,10,'2020-03-14 10:29:52',''),(3,2,3,8,'2020-03-14 10:29:52','666 north'),(3,3,1,NULL,'2020-03-27 11:24:11',''),(3,6,2,10,'2020-03-14 10:29:52',NULL),(4,2,1,8,'2020-03-27 11:14:54','在读的一本简单逻辑学，脑子是个好东西 希望你也有\r\n'),(5,1,2,NULL,'2020-03-27 11:09:48','暂时不想评价'),(6,2,1,NULL,'2020-03-27 11:19:27','好了，我中意看心理学与生活'),(6,3,1,10,'2020-03-27 11:31:16','懂得欣赏！'),(30,1,2,10,'2020-03-14 10:29:52',NULL),(31,1,2,8,'2020-03-14 12:05:20',NULL),(34,1,2,8,'2020-03-14 12:03:30',NULL),(36,1,1,NULL,'2020-03-29 22:17:44',''),(40,1,1,10,'2020-03-14 22:27:43',NULL);
/*!40000 ALTER TABLE `t_book_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_translator`
--

DROP TABLE IF EXISTS `t_translator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_translator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='译者表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_translator`
--

LOCK TABLES `t_translator` WRITE;
/*!40000 ALTER TABLE `t_translator` DISABLE KEYS */;
INSERT INTO `t_translator` VALUES (1,'王垒'),(2,'王甦'),(3,'赵明燕'),(4,'萧宝森'),(5,'冯亚彬'),(6,'刘祥亚'),(7,'孙卫琴'),(8,'萧美惠'),(9,'郑胜得'),(10,'张梦叶'),(11,'颜鹏飞'),(12,'那葳'),(13,'赵德明'),(14,'王渊');
/*!40000 ALTER TABLE `t_translator` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(45) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '用户密码',
  `enabled` varchar(45) DEFAULT NULL COMMENT '用户权限',
  `nickname` varchar(45) DEFAULT NULL,
  `avatar` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `avatar_UNIQUE` (`avatar`),
  UNIQUE KEY `nickname_UNIQUE` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'clio','$2a$10$8939Wcr6uRCXThYWn4FPbeEom9rEvRid.lcp2TaJ6922ACPFg2I/O','1','2020','d5074c48-302b-4622-8ce5-5d400fff38ab.jpg'),(2,'oliver','$2a$10$md0Aryg/GdCbCl75tnz4uuDArJ0S4CSyuGCFYjzzVwo0kZFaz0YUW','1','Oliver','c2228357-fdb5-40ec-a538-1e27962bfd9f.jpg'),(3,'z','$2a$10$WovY.xL8qbE1vPiuLZpOceRv3YC15IpMJ9h6n7zR/aBlBok4dYKMe','1','sunrise',NULL),(4,'c','$2a$10$6cjKTW1uhLTuLTMoqEVWKuodOI6E07a2TgmfdaUM/48HFEFGk4Fve','1','COCO',NULL),(5,'x','$2a$10$Rdd3rchGeVddcHufUfaXnOKJOdfnRREHGKqDV.h5Y1m776z3bTIPm','1','big stone','fc413b56-a9de-4c39-b583-5713e8bc13b1.jpg'),(6,'q','$2a$10$o70lOSnW9cH19J4Q0ZqMSerGoCh9Dm3WYhE/VbJqb/kAB3/WQJ.L2','1','dier','fb091069-7b10-457c-a62c-97cfd99b5138.png'),(7,'g','$2a$10$rL.n93QGrItiJV5b0wVi2OzmCuLunuGN355kbVii.y5EWmEi8NXte','1','scenery','f6f43848-f4ba-4fce-a517-5082e36f02ac.jpg'),(8,'s','$2a$10$kVIE4BJunyKTV4p2mPlLtex2YTVr.UBBaQLmtiGXvh3CRm1dTx6BK','1','山水之间','b2b3f3e0-da8f-4dea-979d-638bb94a2e08.jpg'),(9,'w','$2a$10$YlZO/T.7r9C9APqq7nD2RewWTnfmR0lvjRSr0vMPy9PRwtJOPGFlC','1','88','c85d0504-0b1c-40ea-945e-5a3f8070ec55.jpg'),(10,'e','$2a$10$HkLOHQcJZEhM1IPveT73Nu3RjIJxeJLwqhIXTjcLhZkRGJwBMOvaO','1','西医','73ee7968-7d6a-44cf-b36e-1613ae1dfe03.jpg'),(11,'a','$2a$10$7pwsK8zy7KIL2ExB6mol1ueye4Rt3Gh4LVpYJhhSZ6ah2CNaxnMh2','1','紫色花开','f5ff21af-aa7f-44ba-8388-44f7b6caaee1.jpg'),(12,'r','$2a$10$X20anVwHmkTvabwe5IijWO1FOSeArzGVjigevcQ/6CBIkfkngMhTG','1','日日日','8ac88fcf-6f6a-41b7-b6aa-ceb70a084181.jpg'),(13,'v','$2a$10$1HH7T8LFXRt27q.hG47fOexfNVUPwxtDu05/AQoFWIFV/Xd3NCHUu','1',NULL,NULL),(19,'ww','$2a$10$eUa.xlyBFqRTIjldlnGmGOJpip21t6mX92DIk0lfnSjpNpxLrP9Rm','1',NULL,NULL),(20,'f','$2a$10$42GZHfhKG26tj0mc6iOYlOMwsIVQgHbF9Ik2CWeS4XrwnLfomRMUG','1','wind','1a70f508-19be-4ad4-9f8a-d95a65ad54c4.jpg'),(21,'t','$2a$10$7ocgVdEt2IVGrEzyqCq41eb2er8pNXg.BdgQB1pDNfRQR09QW8QSS','1',NULL,NULL),(22,'i','$2a$10$sZfcQ3OzV0I.jld5Xnh/CuOAMIZ8g920TAqrCTIaY1kVGurr9T/gq','1',NULL,NULL),(23,'d','$2a$10$pNyvqYwGPGgbz.9zY7n2pucTocWmHU4eyGFVR3NSqMgiZTOyucOyC','1','麦田里的守望者','13966597-cb10-42cc-bba3-18b75546767d.jpg'),(24,'n','$2a$10$AiV4Pnv2pkVDCD/0EIt4hOE2e.ZB05Ahw5BulHS0RPaZH7rxLzYDK','1',NULL,NULL),(25,'uu','$2a$10$BvtZUkSB7E9ACz.32Gc6j.faT.3Yf7FFAJHxUS6Tb38K020C7FHgi','1',NULL,NULL),(26,'m','$2a$10$bsflcgrGR8jzUp7KpY8i6.xNHBKF/plhryHzgFGScTwzjmqVbEe0G','1',NULL,NULL),(27,'h','$2a$10$YkqWQdBw4fyh5Agpqcnl8.ClpdVTkGX.7tfUZhXD1IvcJ.rxL36X6','1',NULL,NULL),(28,'j','$2a$10$KBBl48mInrRrKDYjcW6Eousw8wKenaHaQsPZgZVj7Xxh./rE03zIi','1','j','38f61bb9-ff2b-40c7-86f1-ae7e17cfd660.jpg'),(29,'k','$2a$10$RLrmRFkQkt.Q3enkCi3glOzY08hmRKMpKKclfEniZHgbmTm.utiPm','1','kk','ac8a6023-0316-4b02-8103-ca3b00e71a40.jpg');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `v_book_author`
--

DROP TABLE IF EXISTS `v_book_author`;
/*!50001 DROP VIEW IF EXISTS `v_book_author`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_book_author` AS SELECT 
 1 AS `book_id`,
 1 AS `book_name`,
 1 AS `author_name`,
 1 AS `book_isbn`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_book_author_translator`
--

DROP TABLE IF EXISTS `v_book_author_translator`;
/*!50001 DROP VIEW IF EXISTS `v_book_author_translator`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_book_author_translator` AS SELECT 
 1 AS `id`,
 1 AS `name`,
 1 AS `isbn`,
 1 AS `picture`,
 1 AS `publisher`,
 1 AS `publish_year`,
 1 AS `publish_month`,
 1 AS `publish_day`,
 1 AS `price`,
 1 AS `subtitle`,
 1 AS `original_name`,
 1 AS `binding`,
 1 AS `page`,
 1 AS `content_intro`,
 1 AS `author_intro`,
 1 AS `directory`,
 1 AS `author_id`,
 1 AS `author_name`,
 1 AS `translator_id`,
 1 AS `translator_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_book_translator`
--

DROP TABLE IF EXISTS `v_book_translator`;
/*!50001 DROP VIEW IF EXISTS `v_book_translator`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_book_translator` AS SELECT 
 1 AS `book_id`,
 1 AS `book_name`,
 1 AS `translator_id`,
 1 AS `translator_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_book_user_comment`
--

DROP TABLE IF EXISTS `v_book_user_comment`;
/*!50001 DROP VIEW IF EXISTS `v_book_user_comment`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_book_user_comment` AS SELECT 
 1 AS `book_id`,
 1 AS `nickname`,
 1 AS `score`,
 1 AS `time`,
 1 AS `comment`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `v_book_user_starboard`
--

DROP TABLE IF EXISTS `v_book_user_starboard`;
/*!50001 DROP VIEW IF EXISTS `v_book_user_starboard`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `v_book_user_starboard` AS SELECT 
 1 AS `avatar`,
 1 AS `nickname`,
 1 AS `user_id`,
 1 AS `book_id`,
 1 AS `time`,
 1 AS `type`,
 1 AS `score`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `v_book_author`
--

/*!50001 DROP VIEW IF EXISTS `v_book_author`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_book_author` AS select `t_book`.`id` AS `book_id`,`t_book`.`name` AS `book_name`,`t_author`.`name` AS `author_name`,`t_book`.`isbn` AS `book_isbn` from ((`t_book_author` join `t_book` on((`t_book_author`.`book_id` = `t_book`.`id`))) join `t_author` on((`t_book_author`.`author_id` = `t_author`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_book_author_translator`
--

/*!50001 DROP VIEW IF EXISTS `v_book_author_translator`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_book_author_translator` AS select `t_book`.`id` AS `id`,`t_book`.`name` AS `name`,`t_book`.`isbn` AS `isbn`,`t_book`.`picture` AS `picture`,`t_book`.`publisher` AS `publisher`,`t_book`.`publish_year` AS `publish_year`,`t_book`.`publish_month` AS `publish_month`,`t_book`.`publish_day` AS `publish_day`,`t_book`.`price` AS `price`,`t_book`.`subtitle` AS `subtitle`,`t_book`.`original_name` AS `original_name`,`t_book`.`binding` AS `binding`,`t_book`.`page` AS `page`,`t_book`.`content_intro` AS `content_intro`,`t_book`.`author_intro` AS `author_intro`,`t_book`.`directory` AS `directory`,`t_author`.`id` AS `author_id`,`t_author`.`name` AS `author_name`,`t_translator`.`id` AS `translator_id`,`t_translator`.`name` AS `translator_name` from ((((`t_book` join `t_book_author` on((`t_book_author`.`book_id` = `t_book`.`id`))) join `t_author` on((`t_book_author`.`author_id` = `t_author`.`id`))) left join `t_book_translator` on((`t_book_translator`.`book_id` = `t_book`.`id`))) left join `t_translator` on((`t_book_translator`.`translator_id` = `t_translator`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_book_translator`
--

/*!50001 DROP VIEW IF EXISTS `v_book_translator`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_book_translator` AS select `t_book`.`id` AS `book_id`,`t_book`.`name` AS `book_name`,`t_translator`.`id` AS `translator_id`,`t_translator`.`name` AS `translator_name` from ((`t_book_translator` join `t_book` on((`t_book_translator`.`book_id` = `t_book`.`id`))) join `t_translator` on((`t_book_translator`.`translator_id` = `t_translator`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_book_user_comment`
--

/*!50001 DROP VIEW IF EXISTS `v_book_user_comment`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_book_user_comment` AS select `t_book_user`.`book_id` AS `book_id`,`t_user`.`nickname` AS `nickname`,`t_book_user`.`score` AS `score`,`t_book_user`.`time` AS `time`,`t_book_user`.`comment` AS `comment` from (`t_book_user` join `t_user` on((`t_book_user`.`user_id` = `t_user`.`id`))) where ((`t_book_user`.`comment` is not null) and (`t_book_user`.`comment` <> '')) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `v_book_user_starboard`
--

/*!50001 DROP VIEW IF EXISTS `v_book_user_starboard`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_book_user_starboard` AS select `t_user`.`avatar` AS `avatar`,`t_user`.`nickname` AS `nickname`,`t_book_user`.`user_id` AS `user_id`,`t_book_user`.`book_id` AS `book_id`,`t_book_user`.`time` AS `time`,`t_book_user`.`type` AS `type`,`t_book_user`.`score` AS `score` from (`t_book_user` join `t_user` on((`t_book_user`.`user_id` = `t_user`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-31 20:20:31
