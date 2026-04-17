-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: ecommerce_info
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `brand` varchar(100) DEFAULT NULL,
  `description` text,
  `price` decimal(10,2) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `discountPrice` decimal(10,2) DEFAULT NULL,
  `rating` decimal(5,1) DEFAULT '0.0',
  `stock` int DEFAULT '0',
  `img` varchar(250) DEFAULT NULL,
  `dateAdded` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (9,'TechPulse – The Heartbeat of Modern Electronics','Electronics','TechPluse','Where Digital Meets Innovation',6000.00,NULL,400.00,4.2,10,'photo-1545127398-14699f92334b.avif','2026-04-15 14:56:33'),(10,'InfiVolt – Infinite Power, Infinite Possibilities','Electronics','InfiVolt','Redefining Electronics',10000.00,NULL,2999.00,3.6,50,'photo-1587829741301-dc798b83add3.avif','2026-04-15 15:36:44'),(11,'ElectroSphere – Your Digital Electronics World','Electronics','ElectroSphere','Explore. Connect. Innovate.',2000.00,NULL,120.00,4.6,4,'photo-1595044426077-d36d9236d54a.avif','2026-04-15 15:38:05'),(12,'CircuitNova – Next Gen Electronics Hub','Electronics','CircuitNova','Innovation in Every Connection',4000.00,NULL,200.00,4.0,2,'photo-1618366712010-f4ae9c647dcb.avif','2026-04-15 15:39:25'),(13,'DigiCircuit – Smart Electronics Marketplace','Electronics','DigiCircuit','Where Digital Meets Innovation',3000.00,NULL,1500.00,3.6,5,'premium_photo-1679513691474-73102089c117.avif','2026-04-15 15:40:11'),(14,'InfiVolt – Infinite Power, Infinite Possibilities','Electronics','InfiVolt','Redefining Electronics',4500.00,NULL,230.00,3.6,6,'premium_photo-1681666713680-fb39c13070f3.avif','2026-04-15 15:41:00'),(15,'TechPulse – The Heartbeat of Modern Electronics','Electronics','TechPulse','Feel the Pulse of Innovation',4567.00,NULL,432.00,3.5,45,'premium_photo-1679513691474-73102089c117.avif','2026-04-15 15:42:46'),(16,'InfiVolt – Infinite Power, Infinite Possibilities','Electronics','InfiVolt','Redefining Electronics',4304.00,NULL,345.00,4.7,60,'premium_photo-1681666713680-fb39c13070f3.avif','2026-04-15 15:44:03'),(17,'“Everything You Need, One Click Away”','Fashion','ShopSphere','ShopSphere is your all-in-one online shopping destination for fashion, electronics, and daily essentials. Enjoy fast delivery, great deals, and a smooth shopping experience.',2000.00,NULL,399.00,4.6,5,'photo-1490481651871-ab68de25d43d.avif','2026-04-15 15:49:18'),(18,'Your Comfort Zone for Online Shopping','Fashion','BuyNest','BuyNest offers a trusted and easy shopping platform where quality meets affordability. Discover a wide range of products at the best prices with secure checkout.',3400.00,NULL,200.00,4.5,5,'photo-1529139574466-a303027c1d8b.avif','2026-04-15 15:50:36'),(19,'Stay Ahead with Every Trend','Fashion','TrendKart','TrendKart brings you the latest fashion, gadgets, and trending products. Upgrade your lifestyle and stay updated with what’s new in the market.',4555.00,NULL,34.00,4.5,34,'photo-1539109136881-3be0616acf4b.avif','2026-04-15 15:51:26'),(20,'India’s Digital Shopping Market','Fashion','ClickBazaar','ClickBazaar is a modern marketplace offering thousands of products at unbeatable prices. Shop easily, safely, and quickly from anywhere',4332.00,NULL,221.00,4.5,5,'photo-1571513800374-df1bbe650e56.avif','2026-04-15 15:52:11'),(21,'Modern Shopping for Urban Life','Fashion','UrbanCart','UrbanCart is designed for today’s urban lifestyle, offering stylish, practical, and high-quality products for everyday needs.',545.00,NULL,321.00,3.2,66,'photo-1574201635302-388dd92a4c3f.avif','2026-04-15 15:52:55'),(22,'Big Deals, Bigger Savings','Fashion','MegaMart Hub',': MegaMart Hub is your destination for massive discounts and exciting offers across all categories. Shop more and save more every day.',5444.00,NULL,542.00,4.3,5,'photo-1601762603339-fd61e28b698a.avif','2026-04-15 15:54:28'),(23,'Fast Shopping, Smart Choices','Fashion','QuickBuy Zone','QuickBuy Zone is built for fast and hassle-free shopping. Find what you need quickly and enjoy smooth delivery at your doorstep',5432.00,NULL,1234.00,4.3,5,'premium_photo-1664202526559-e21e9c0fb46a.avif','2026-04-15 15:55:14'),(24,'Stack Your Style, Shop Your Way','Fashion','StyleStack','StyleStack is perfect for fashion lovers who want to explore trendy outfits and accessories. Build your style the way you like.',5433.00,NULL,345.00,5.0,6,'premium_photo-1675186049366-64a655f8f537.avif','2026-04-15 15:56:43'),(25,' Make Every Corner Beau','Electronics','HomeLuxe Studio','HomeLuxe Studio brings elegant and modern home décor items to transform your space into a stylish and comfortable home.',45555.00,NULL,3426.00,5.0,6,'photo-1534349762230-e0cadf78f5da.avif','2026-04-15 15:58:13'),(26,'Style Your Space with Love','Fashion','DecorNest','DecorNest offers a wide collection of home decoration products that add warmth, beauty, and personality to your home.',5000.00,NULL,2000.00,3.5,6,'photo-1572048572872-2394404cf1f3.avif','2026-04-15 15:59:18'),(27,'Modern Decor for Modern Homes','Home','UrbanDecor Hub','UrbanDecor Hub provides trendy and aesthetic décor pieces designed for today’s modern lifestyle and interiors.',4000.00,NULL,3000.00,5.0,50,'photo-1582131503261-fca1d1c0589f.avif','2026-04-15 16:00:06'),(28,'Turn Your House into a Dream Home','Home','DreamHome Decor','DreamHome Decor helps you create beautiful living spaces with stylish and affordable decoration items.',40000.00,NULL,2345.00,4.5,4,'photo-1615874694520-474822394e73.avif','2026-04-15 16:01:01'),(29,'Feel the Beauty of Every Space','Home','AuraLiving','AuraLiving offers premium home décor products that bring elegance, comfort, and positive vibes to your home.',3456.00,NULL,345.00,4.5,4,'photo-1616047006789-b7af5afb8c20.avif','2026-04-15 16:02:10'),(30,'Add Charm to Your Home','Home','CasaCharm','CasaCharm features unique and artistic décor items that make every room look special and inviting.',43223.00,NULL,445.00,5.0,6,'photo-1618220179428-22790b461013.avif','2026-04-15 16:03:06'),(31,'Luxury That Feels Like Home','Home','EliteHome Decor','EliteHome Decor delivers high-quality and luxurious decoration pieces to upgrade your interior design.',3000.00,NULL,343.00,4.0,76,'photo-1583847268964-b28dc8f51f92.avif','2026-04-15 16:04:01');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-17 14:23:14
