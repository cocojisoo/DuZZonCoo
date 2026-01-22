@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.TIME)
    private UUID id;

    @Column(length = 30)
    @NotBlank(message = "제목을 입력해주시긔")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Column(length = 10)
    @NotBlank(message = "미 기재시, 익명(숫자)로 처리되긔")
    private String writer;

    @Column(length = 10)
    @NotBlank(message = "비밀번호를 입력해주시긔")
    private String password;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;


}