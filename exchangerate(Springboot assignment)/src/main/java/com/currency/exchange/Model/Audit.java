package com.currency.exchange.Model;

import java.sql.Timestamp;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name="audit")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long request_id;
    String status;
    String request;
    String Response;
    Timestamp create_ts;
    Timestamp update_ts;
}
