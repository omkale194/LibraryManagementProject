<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin page</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
   <link rel="stylesheet" href="style.css">
   <style>
   form{
   display:flex;
   
   }
   
   </style>
</head>
<div class="container">
        <header>
            <div class="logo">Book
            <i class="fas fa-book"></i>
            </div>
            <nav>
                <ul>
                    <li><a href="moreinfo">About</a></li>
                    <li><a href="erdiagram">ER-Diagram</a></li>
                    <li><a href="#">Popular</a></li>
                    <li><a href="#">Help</a></li>
                </ul>
            </nav>
            <div class="cta-buttons">
                <a href="/"><button class="btn btn-secondary">Logout</button></a>
            </div>
        </header>

        <main>
            <section class="hero">
                <div class="hero-content">
                    <h1 style="color:#226B68">A Book Can Change Your Life....</h1>
                   <div class="search-bar">
	               <form action="searchid" method="get">
	 	            <input type="text" name="bookid" placeholder="Enter Bookid" required autocomplete="off">
		            <button type="submit">Search</button>
	               </form>
	              
	               </div>
 				<br><br>
                    
                </div>
                <div class="hero-image">
                    <img src="images/5.webp" alt="Soul is a River book cover">
                   
                </div>
            </section>
        </main>

        <section class="all-info-queries">
            <p><b> Book Operation According to Their Criteria</b></p>
           <div class="queries1">
                <a href="adbook"><button>add a book</button></a>
                <a href="allbook"><button>Find all book List</button></a>
                <a href="upprice"><button>Update Book Price</button></a>
                <a href="delbook"><button>Delete A  Book</button></a>
            </div>
            
            <div class="queries1">
               <a href="searchbygen"><button>Search By genre</button></a>
               <a href="isbnno"><button>Find ISBN No</button></a>
				<a href="addrecord"><button>Book_Records</button></a>
                <a href="delrecord"><button>All delete Books Records</button></a>
            </div>
            
         
        </section>
        <br>
             <section class="all-info-queries1">
            <p><b> Staff Operation According to Their Criteria</b></p>
            <div class="queries1">
                <a href="allstaff"><button>All Staff List</button></a>
                <a href="addstaff"><button>Add Staff</button></a>
                <a href="updatestaffsal"><button>Update salary</button></a>
                <a href="deletestaff"><button>Delete Staff</button></a>
            </div>
 
        </section>
         <br>
             <section class="all-info-queries1">
            <p><b> Member Operation According to Their Criteria</b></p>
            <div class="queries1">
                <a href="allmembers"><button>All Members List</button></a>
                <a href="newmem"><button>Add Members</button></a>
                <a href="deletemem"><button>Delete Members</button></a>
            </div>
 
        </section>
        
    </div>
    <footer>
        <div class="container">
            <p>&copy; 2024 Booklearn. All rights reserved.</p>
        </div>
    </footer>
</body>
</html>