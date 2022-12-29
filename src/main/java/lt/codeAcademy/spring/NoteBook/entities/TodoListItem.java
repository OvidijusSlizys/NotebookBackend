package lt.codeAcademy.spring.NoteBook.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "todoListItems")
public class TodoListItem
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime expiresAt;
//     @ManyToOne
//    @JoinColumn(name = "todo_list_id", referencedColumnName = "id")
//    private TodoList todoList;

	public String getCreatedAtFormatted(){
		return this.getFormattedDate(this.createdAt);
	}
	
	public String getUpdatedAtFormatted(){
		return this.getFormattedDate(this.updatedAt);
	}
	
	public String getExpiresAtFormatted(){
		return this.getFormattedDate(this.expiresAt);
	}
	
	private String getFormattedDate(LocalDateTime date) {
		if (date ==null) {
			return null;
		}
		DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				return date.format(formater);
	}
	


   
    
    
    
    
}
