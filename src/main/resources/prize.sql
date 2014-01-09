UPDATE prize
SET total_count = total_count - 7000,
current_count = current_count - 7000
WHERE prize_id = 1;

UPDATE prize
SET active_yn = 'N'
WHERE prize_id IN(2,3,4,5);
