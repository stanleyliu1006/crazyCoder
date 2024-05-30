SELECT *
FROM (
         SELECT A.event_type, A.value - LEAD(A.value) OVER (PARTITION BY A.event_type ORDER BY A.event_type) AS value
         FROM (
             SELECT *, RANK() OVER (PARTITION BY event_type ORDER BY time DESC) AS RANK
             FROM events
             ) AS A
         WHERE A.RANK <= 2
     ) AS B
WHERE B.value is not null